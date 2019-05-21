package com.pigcanfly.translate.filter.impl;

import com.pigcanfly.translate.filter.Filter;

/**
 * @author Tobby Quinn
 * @date 2019/05/17
 */
public class SensitiveFilter implements Filter {
    @Override
    public String execute(String translateText) {
        return translateText.replaceAll("大傻逼","***").replaceAll("草","*");
    }
}
