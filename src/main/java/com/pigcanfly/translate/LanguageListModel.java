package com.pigcanfly.translate;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

/**
 * 此处的泛型类型应该和ListCellRendererWrapper<T>的泛型保持一致
 *
 * @author Tobby Quinn
 * @date 2019/05/09
 */
public class LanguageListModel extends AbstractListModel<Lang> implements ComboBoxModel<Lang> {
    /**
     * 遍历Enum Lang 并赋值
     */
    private static List<Lang> langList = Arrays.asList(Lang.values());

    /**
     * 每次选择的内容为LangNameKey，并不是Lang enum类型本身
     */
    private Lang selected = Lang.AUTO;


    @Override
    public int getSize() {
        return langList.size();
    }

    @Override
    public Lang getElementAt(int index) {
        return langList.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selected =(Lang) anItem;
        //TODO:查找该方法作用
        //参考 DefaultComboBoxModel 的 addElement方法
        fireContentsChanged(this, -1, -1);
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }


}
