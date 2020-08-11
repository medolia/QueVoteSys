package com.que.votesys.util;

import java.util.HashMap;
import java.util.Map;

public class OptionAnalyzer {
    private static Map<String, String> strToMap(String optString) {
        Map<String, String> resultMap = new HashMap<>();
        String[] optList = optString.strip().split("##");
        for (String opt : optList) {
            resultMap.put(opt.split("#")[0], opt.split("#")[1]);
        }
        return resultMap;
    }

    /*public static void main(String[] args) {
        System.out.println(OptionAnalyzer.strToMap("0#1##1#2##2#0##3#1"));
    }*/
}
