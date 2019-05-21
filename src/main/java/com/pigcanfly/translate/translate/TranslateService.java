package com.pigcanfly.translate.translate;

import com.pigcanfly.translate.Lang;
import com.pigcanfly.translate.UrlBuilder;

/**
 * @author Tobby Quinn
 * @date 2019/05/14
 */
public class TranslateService {

    public static void main(String[] args) {
        String build = new UrlBuilder("http://www.baidu.com")
                .addQueryParameter("q", "hello")
                .addQueryParameter("v", "world")
                .build();
        System.out.println(build);
        System.out.println("\u590d\u5236\u8bd1\u6587");
        System.out.println("\u6536\u85cf\u8bd1\u6587");
        Lang en = Lang.getLangByCode("en");
        System.out.println(en);
    }

}
