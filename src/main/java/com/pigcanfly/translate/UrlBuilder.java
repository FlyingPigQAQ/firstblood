package com.pigcanfly.translate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Tobby Quinn
 * @date 2019/05/14
 */
public class UrlBuilder {

    private StringBuilder baseUrl;

    private ArrayList<Pair> pairs = new ArrayList<>();

    public UrlBuilder(String url) {
        baseUrl = new StringBuilder(url);
    }


    public UrlBuilder addQueryParameter(String key, String value) {
        pairs.add(new Pair(key,value));
        return this;
    }

    public String build(){
        baseUrl.append("?");
        pairs.stream().forEach(x->{
            try {
                baseUrl.append(x.getKey()+"="+URLEncoder.encode(x.getValue(),"utf-8")+"&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        });
        return baseUrl.toString();
    }


    class Pair{
        private String key;
        private String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
