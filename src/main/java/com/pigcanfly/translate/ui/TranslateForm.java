package com.pigcanfly.translate.ui;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.DocumentAdapter;
import com.intellij.util.Alarm;
import com.intellij.util.io.HttpRequests;
import com.pigcanfly.translate.Lang;
import com.pigcanfly.translate.LanguageListModel;
import com.pigcanfly.translate.LanguageRender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * @author Tobby Quinn
 * @date 2019/05/05
 */
public class TranslateForm extends DialogWrapper {
    private JPanel root;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea sourceArea;
    private JTextPane targetArea;

    private Alarm alarm=new Alarm();


    /**
     * setModel设置非模态窗口
     * 模态窗口：不接受其他窗口响应
     * 非模态窗口：可以操作其他界面
     */
    public TranslateForm(@Nullable Project project, boolean canBeParent) {
        super(project, canBeParent);
        setModal(false);
        setTitle("翻译");
        init();
        initComponent();
    }

    private void initComponent() {
        initComboBox();
        initButton();
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
        comboBox1.setModel(new LanguageListModel());

        comboBox2.setRenderer(new LanguageRender());
        comboBox2.setModel(new LanguageListModel());
    }

    private void initButton() {
        button1.addActionListener(e -> {
            Lang sourceTmp = (Lang) comboBox1.getSelectedItem();
            Lang targetTmp = (Lang) comboBox2.getSelectedItem();
            comboBox1.setSelectedItem(targetTmp);
            comboBox2.setSelectedItem(sourceTmp);
//            因为展示selected是本地化,和selected本身是不一致的，所以重新渲染UI
//            comboBox1.updateUI();
//            comboBox2.updateUI();
        });
    }
    private void initTextArea(){
        sourceArea.getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent e) {
                if(e.getLength()>0){
                    requestTranslate();
                }
            }
        });
    }

    private void requestTranslate(){
        alarm.cancelAllRequests();
        alarm.addRequest(()->{
            onTranslate();
        },300);
    }
    private void onTranslate(){
        if(!sourceArea.getText().isEmpty()){
            translate(sourceArea.getText(),(Lang)comboBox1.getSelectedItem(),(Lang)comboBox2.getSelectedItem());
        }
    }

    private void translate(String text, Lang selectedItem, Lang selectedItem1) {

        //HttpRequests.request()
    }


}
