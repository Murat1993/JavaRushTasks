package com.javarush.task.task08.task0818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Some name1", 600);
        map.put("Some name2", 600);
        map.put("Some name3", 600);
        map.put("Some name4", 600);
        map.put("Some name5", 600);
        map.put("Some name6", 600);
        map.put("Some name7", 600);
        map.put("Some name8", 600);
        map.put("Some name9", 600);
        map.put("Some name10", 600);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getValue() < 500) {
                list.add(pair.getKey());
            }
        }

        for (String string : list) {
            map.remove(string);
        }

    }

    public static void main(String[] args) {

    }
}