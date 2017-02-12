package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
1. Создай список строк.
2. Добавь в него 10 строчек с клавиатуры.
3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
Если таких строк несколько, то должны быть учтены самые первые из них.
4. Выведи на экран строку из п.3.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
        }

        int maxLength = list.get(0).length();
        int minLength = list.get(0).length();

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).length() == maxLength || list.get(i).length() == minLength) {
                continue;
            }

            if (list.get(i).length() > maxLength) {
                maxLength = list.get(i).length();
                maxIndex = i;
                continue;
            }

            if (list.get(i).length() < minLength) {
                minLength = list.get(i).length();
                minIndex = i;
            }
        }

        if (minIndex < maxIndex) {
            System.out.println(list.get(minIndex));
        }

        if (minIndex > maxIndex) {
            System.out.println(list.get(maxIndex));
        }



    }
}
