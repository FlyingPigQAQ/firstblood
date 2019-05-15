package com.pigcanfly.translate.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.impl.ApplicationImpl;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.ui.AppUIUtil;
import com.pigcanfly.translate.ui.TranslateForm;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author Tobby Quinn
 * @date 2019/05/05
 */
public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

//        ListPopup listPopup = JBPopupFactory.getInstance().createListPopup(new TranslateForm());
//        listPopup.showInFocusCenter();
        AppUIUtil.invokeLaterIfProjectAlive(e.getProject(),()->{
            TranslateForm translateForm = new TranslateForm(e.getProject(),true);
            translateForm.show();

        });

    }

}
