package com.pigcanfly.translate.filter;

/**
 * @author Tobby Quinn
 * @date 2019/05/20
 */
public class FilterManager {
    private FilterChain filterChain;

    public FilterManager(FilterChain filterChain){
        this.filterChain=filterChain;
    }

    public String execute(String text){
       return  filterChain.doFilter(text);
    }
}
