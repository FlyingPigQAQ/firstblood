package com.pigcanfly.translate.filter;

import com.pigcanfly.translate.filter.impl.CommentFilter;
import com.pigcanfly.translate.filter.impl.SensitiveFilter;

/**
 * @author Tobby Quinn
 * @date 2019/05/17
 */
public class Client {
    public static void main(String[] args) {
        String text= "你是大傻逼，哈哈哈，草";
        FilterChain filterChain = new FilterChain()
                .addFilter(new CommentFilter())
                .addFilter(new SensitiveFilter());

        FilterManager filterManager = new FilterManager(filterChain);
        String execute = filterManager.execute(text);
        System.out.println(execute);
    }
}
