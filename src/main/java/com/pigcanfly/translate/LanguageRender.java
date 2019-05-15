package com.pigcanfly.translate;

import com.intellij.ui.ListCellRendererWrapper;

import javax.swing.*;

/**
 * @author Tobby Quinn
 * @date 2019/05/06
 */
public class LanguageRender extends ListCellRendererWrapper<Lang> {


    @Override
    public void customize(JList list, Lang value, int index, boolean selected, boolean hasFocus) {
        //通过Lang的langNameKey，获取本地化字符
        setText(value.getLocaleLanguage());
    }


}
