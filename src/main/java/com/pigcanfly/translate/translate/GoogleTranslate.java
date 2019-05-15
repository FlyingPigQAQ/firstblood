package com.pigcanfly.translate.translate;

import com.pigcanfly.translate.Lang;
import com.pigcanfly.translate.UrlBuilder;

/**
 * tk算法源码
 * <p>
 * var Xn = function (a) {
 * return function () {
 * return a
 * }
 * }, Yn = function (a, b) {
 * for (var c = 0; c < b.length - 2; c += 3) {
 * var d = b.charAt(c + 2);
 * d = "a" <= d ? d.charCodeAt(0) - 87 : Number(d);
 * d = "+" == b.charAt(c + 1) ? a >>> d : a << d;
 * a = "+" == b.charAt(c) ? a + d & 4294967295 : a ^ d
 * }
 * return a
 * }, Zn = null, $n = function (a) {
 * if (null !== Zn) var b = Zn; else {
 * b = Xn(String.fromCharCode(84));
 * var c = Xn(String.fromCharCode(75));
 * b = [b(), b()];
 * b[1] = c();
 * b = (Zn = window[b.join(c())] || "") || ""
 * }
 * var d = Xn(String.fromCharCode(116));
 * c = Xn(String.fromCharCode(107));
 * d = [d(), d()];
 * d[1] = c();
 * c = "&" + d.join("") +
 * "=";
 * d = b.split(".");
 * b = Number(d[0]) || 0;
 * for (var e = [], f = 0, g = 0; g < a.length; g++) {
 * var h = a.charCodeAt(g);
 * 128 > h ? e[f++] = h : (2048 > h ? e[f++] = h >> 6 | 192 : (55296 == (h & 64512) && g + 1 < a.length && 56320 == (a.charCodeAt(g + 1) & 64512) ? (h = 65536 + ((h & 1023) << 10) + (a.charCodeAt(++g) & 1023), e[f++] = h >> 18 | 240, e[f++] = h >> 12 & 63 | 128) : e[f++] = h >> 12 | 224, e[f++] = h >> 6 & 63 | 128), e[f++] = h & 63 | 128)
 * }
 * a = b;
 * for (f = 0; f < e.length; f++) a += e[f], a = Yn(a, "+-a^+6");
 * a = Yn(a, "+-3^+b+-f");
 * a ^= Number(d[1]) || 0;
 * 0 > a && (a = (a & 2147483647) + 2147483648);
 * a %= 1E6;
 * return c + (a.toString() + "." +
 * (a ^ b))
 * };
 * <p>
 * tk js源码分析
 * String.fromCharCode(84); // T
 * String.fromCharCode(75)  // K
 * //TODO return function
 * var b = Xn(String.fromCharCode(84)); // function Xn()
 * var c = Xn(String.fromCharCode(75));  // function Xn()
 * b() // T
 * b = [b(), b()]; // Array ["T","T"]
 * c()  //K
 * b[1] = c();   //  Array ["T","K"]
 * b.join("K") // TKK
 * Zn = window[b.join(c())] // window["TKK] 获取窗口TKK对象，并赋值给Zn
 * Zn //432726.2469917364
 * b = (Zn = window[b.join(c())] || "") || "" //如果Zn即TKK对象存在，赋值给b,否则赋值空字符串”“  432726.2469917364
 * String.fromCharCode(116) // t
 * var d = Xn(String.fromCharCode(116)); // function Xn()
 * String.fromCharCode(107) // k
 * c = Xn(String.fromCharCode(107)); //function Xn()
 * d = [d(), d()]; // Array ["t","t"]
 * d[1] = c(); // Array ["t","k"]
 * c = "&" + d.join("") + "="; // &tk=
 * d = b.split("."); //TKK.split() Array ["432726", "2469917364"]
 * b = Number(d[0]) || 0; //字符串转数字 432726
 * <p>
 * //参数a是翻译远文本
 * for (var e = [], f = 0, g = 0; g < a.length; g++) {
 * var h = a.charCodeAt(g);
 * 128 > h ? e[f++] = h : (2048 > h ? e[f++] = h >> 6 | 192 : (55296 == (h & 64512) && g + 1 < a.length && 56320 == (a.charCodeAt(g + 1) & 64512) ? (h = 65536 + ((h & 1023) << 10) + (a.charCodeAt(++g) & 1023), e[f++] = h >> 18 | 240, e[f++] = h >> 12 & 63 | 128) : e[f++] = h >> 12 | 224, e[f++] = h >> 6 & 63 | 128), e[f++] = h & 63 | 128)
 * }
 *
 * @author Tobby Quinn
 * @date 2019/05/14
 */
public class GoogleTranslate {
    private static final String BASE_URL = "https://translate.google.cn/translate_a/single";
    //TODO： TK 值可能发生变化
    private static final String TKK = "432726.2469917364";

    public static String getTranslateUrl(String text, Lang srcLang, Lang targetLang) {
        return new UrlBuilder(BASE_URL)
                .addQueryParameter("client", "gtx")
                //.addQueryParameters("dt", "t", /*"at",*/ "bd", "rm")
                .addQueryParameter("dj", "1")
                .addQueryParameter("ie", "UTF-8")
                .addQueryParameter("oe", "UTF-8")
                .addQueryParameter("sl", srcLang.getCode())
                .addQueryParameter("tl", targetLang.getCode())
                //.addQueryParameter("hl", primaryLanguage.code) // 词性的语言
                //TODO java 实现google translate api tk算法
                .addQueryParameter("tk", getTk(text))
                .addQueryParameter("q", text)
                .build();
    }

    public static String getTranslateUrl(String text, String srcLang, String targetLang) {
        return new UrlBuilder(BASE_URL)
                .addQueryParameter("client", "gtx")
                .addQueryParameter("dt", "t")
                .addQueryParameter("dt", "bd")
                .addQueryParameter("dt", "rm")
                .addQueryParameter("dj", "1")
                .addQueryParameter("ie", "UTF-8")
                .addQueryParameter("oe", "UTF-8")
                .addQueryParameter("sl", srcLang)
                .addQueryParameter("tl", targetLang)
                // 词性的语言
                .addQueryParameter("hl", "zh-CN")
                //TODO java 实现google translate api tk算法
                .addQueryParameter("tk", getTk(text))
                .addQueryParameter("q", text)
                .build();
    }

    public static void main(String[] args) {
        String hello = GoogleTranslate.getTranslateUrl("新年快乐", "zh-CN", "en");
        System.out.println(hello);
    }

    protected static String getTk(String text) {
        String[] tkks = TKK.split("\\.");
        long a = Long.valueOf(tkks[0]);
        long b = Long.valueOf(tkks[1]);
        //遍历text
        int[] e = new int[text.length()];
        for (int g = 0, f = 0; g < text.length(); g++) {
            char h = text.charAt(g);
            if (128 > h) {
                e[f++] = h;
            } else {
                if (2048 > h) {
                    e[f++] = h >> 6 | 192;
                } else {
                    if (55296 == (h & 64512) && g + 1 < text.length() && 56320 == (text.charAt(g + 1) & 64512)) {
                        h = (char) (65536 + ((h & 1023) << 10) + (text.charAt(++g) & 1023));
                        e[f++] = h >> 18 | 240;
                        e[f++] = h >> 12 & 63 | 128;
                    }
                }
                e[f++] = h & 63 | 128;
            }
        }

        for (int f = 0; f < e.length; f++) {
            a += e[f];
            a = Yn(a, "+-a^+6");
        }
        a = Yn(a, "+-3^+b+-f");
        a ^= (int) 'k';
        if (0 > a) {
            a = (a & 2147483647) + 2147483648L;
        }
        a %= 1E6;
        return a + "." + (a ^ b);
    }

    private static long Yn(long a, String b) {

        for (int c = 0; c < b.length() - 2; c += 3) {
            char d = b.charAt(c + 2);
            d = 'a' <= d ? (char) (String.valueOf(d).codePointAt(0) - 87) : (d);
            d = '+' == b.charAt(c + 1) ? (char) (a >>> d) : (char) (a << d);
            a = '+' == b.charAt(c) ? a + d & 4294967295L : a ^ d;
        }
        return a;
    }

}
