package com.pigcanfly.translate.translate;

import com.intellij.openapi.ide.CopyPasteManager;
import com.pigcanfly.translate.Lang;
import com.pigcanfly.translate.UrlBuilder;

import java.awt.datatransfer.Transferable;

/**
 * @author Tobby Quinn
 * @date 2019/05/14
 */
public class TranslateService {

    public static void main(String[] args) {
        Transferable contents = CopyPasteManager.getInstance().getContents();
        System.out.println(contents);
    }

}
