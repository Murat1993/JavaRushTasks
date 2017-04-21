package com.javarush.task.task22.task2208;

import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() == null || pair.getKey() == null) {
                continue;
            }
            builder.append(pair.getKey()).append(" = '").append(pair.getValue()).append("' and ");
        }
        if (builder.length() > 0) {
            builder.delete(builder.length() - 5, builder.length());
        }
        return builder.toString();
    }
}
