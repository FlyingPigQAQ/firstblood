package com.pigcanfly.translate.ui;

import com.google.gson.Gson;
import com.intellij.ide.actions.CopyReferenceAction;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.ide.CopyPasteManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.IdeFocusManager;
import com.intellij.ui.DocumentAdapter;
import com.intellij.ui.WindowResizeListener;
import com.intellij.util.Alarm;
import com.intellij.util.io.HttpRequests;
import com.intellij.util.io.RequestBuilder;
import com.pigcanfly.translate.Lang;
import com.pigcanfly.translate.LanguageListModel;
import com.pigcanfly.translate.LanguageRender;
import com.pigcanfly.translate.translate.GoogleTranslate;
import com.pigcanfly.translate.translate.result.GoogleTranslateResult;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.awt.datatransfer.ClipboardTransferable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 如果允许用户自己调整窗口大小的话，那么内部的Panel宽高不能Fixed,否则会发生内部组件大小不跟随容器大小变化。
 * 2. 通过设置最外层JPanel的Minimum Size来限定用户最小Resize窗口
 *
 * @author Tobby Quinn
 * @date 2019/05/05
 */
public class TranslateForm extends DialogWrapper implements Disposable {
    private JPanel root;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea sourceArea;
    private JTextArea targetArea;

    private Project myProject;

    private Alarm alarm = new Alarm(this);

    private boolean disposed = false;

    private Runnable translateAction = this::onTranslate;
    private static CopyPasteManager copyPasteManager = CopyPasteManager.getInstance();
    private IdeFocusManager focusManager = IdeFocusManager.getInstance(myProject);

    @Override
    public boolean isDisposed() {
        return disposed;
    }

    public void setDisposed(boolean disposed) {
        this.disposed = disposed;
    }

    /**
     * setModel设置非模态窗口
     * 模态窗口：不接受其他窗口响应
     * 非模态窗口：可以操作其他界面
     */
    public TranslateForm(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
        this.myProject=project;
        setModal(false);
        setTitle("翻译");
        init();
        initComponent();

    }

    private void initComponent() {
        initComboBox();
        initButton();
        initTextArea();

    }


    @Override
    public void show() {
        super.show();
        //图形展示后执行，让光标聚焦到JTextArea输入框

        focusManager.requestFocus(sourceArea,true);
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return root;
    }


    /**
     * 取消OK，cancel 按钮
     *
     * @return
     */
    @NotNull
    @Override
    protected Action[] createActions() {
        return new Action[0];
    }

    private void initComboBox() {
        comboBox1.setRenderer(new LanguageRender());
        Lang[] srcLangs = Lang.values();
        comboBox1.setModel(new LanguageListModel(srcLangs,Lang.AUTO));

        comboBox2.setRenderer(new LanguageRender());
        //目标语言排除 `自动检测`功能
        Lang[] targetLangs = Arrays.copyOfRange(Lang.values(), 1, Lang.values().length - 1);
        comboBox2.setModel(new LanguageListModel(targetLangs,Lang.ENGLISH));
        //发生勾选事件，发起翻译请求
        ItemListener itemListener = e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                requestTranslate();
            }
        };
        //监听Item
        comboBox1.addItemListener(itemListener);
        comboBox2.addItemListener(itemListener);
    }

    private void initButton() {
        button1.addActionListener(e -> {
            Lang sourceTmp = (Lang) comboBox1.getSelectedItem();
            Lang targetTmp = (Lang) comboBox2.getSelectedItem();
            comboBox1.setSelectedItem(targetTmp);
            comboBox2.setSelectedItem(sourceTmp);
            //再次发起翻译请求
            requestTranslate();



        });
    }



    private void initTextArea() {
       //先添加监听，再从剪切板获取内容，否则即使剪切板的内容到输入框，导致文本内容发生变化
        //但因为监听器没加载，不会发起request请求
        sourceArea.getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent e) {
                if (e.getLength() > 0) {
                    requestTranslate();
                }
            }
        });

        //初始化，从剪切板获取数据
//        String clipboard = CopyPasteManager.getInstance().getContents(DataFlavor.stringFlavor);
//        if(!StringUtils.isEmpty(clipboard)){
//            //直接set导致JTextArea水平拉长
//          sourceArea.setText(clipboard);
          //sourceArea.paste();
       // sourceArea.setLineWrap(true);

//        }

    }

    private void requestTranslate() {
        alarm.cancelAllRequests();
        //延迟300毫秒发送请求
        alarm.addRequest(translateAction, 300);
    }

    private void onTranslate() {
        if (!sourceArea.getText().isEmpty()) {
            translate(sourceArea.getText(), (Lang) comboBox1.getSelectedItem(), (Lang) comboBox2.getSelectedItem());

        }
    }

    private void translate(String text, Lang sourceLang, Lang TargetLang) {

        RequestBuilder builder = HttpRequests.request(GoogleTranslate.getTranslateUrl(text, sourceLang, TargetLang));
        builder.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:66.0) Gecko/20100101 Firefox/66.0");
        //使用线程池，如果不使用，则会因为http响应慢导致阻塞TextArea输入窗口,给人卡顿的感觉
        ApplicationManager.getApplication().executeOnPooledThread(() -> {
            try {
                GoogleTranslateResult resultOfGoogle = builder.connect(request -> {
                    //2018.1版本不支持空参方法，需要手动设置
                    String result = request.readString(null);
                    Gson gson = new Gson();
                    GoogleTranslateResult googleTranslateResult = gson.fromJson(result, GoogleTranslateResult.class);
                    return googleTranslateResult;
                });
                StringBuilder sb = new StringBuilder();
                resultOfGoogle.getSentences().stream().forEach(x -> {
                    sb.append(x.getTrans() != null ? x.getTrans() : "");
                });
                targetArea.setText(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }


    @Override
    public void dispose() {
        if (isDisposed()) {
            return;
        }

        super.dispose();
        setDisposed(true);
        Disposer.dispose(this);
    }


}
