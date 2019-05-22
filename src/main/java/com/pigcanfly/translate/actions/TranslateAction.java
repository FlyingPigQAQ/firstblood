package com.pigcanfly.translate.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ui.AppUIUtil;
import com.pigcanfly.translate.ui.TranslateForm;
import org.jetbrains.annotations.NotNull;

/**
 * @author Tobby Quinn
 * @date 2019/05/05
 */
public class TranslateAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

        AppUIUtil.invokeLaterIfProjectAlive(e.getProject(), () -> {
            TranslateForm translateForm = new TranslateForm(e.getProject(), true);
            translateForm.show();

        });

    }

}
