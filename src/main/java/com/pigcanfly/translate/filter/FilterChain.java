package com.pigcanfly.translate.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tobby Quinn
 * @date 2019/05/17
 */
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter) {
        filters.add(filter);
        return this;
    }

    public String doFilter(String text) {
        for (int i = 0; i < filters.size(); i++) {
            text = filters.get(i).execute(text);
        }
        return text;
    }
}
