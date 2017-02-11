package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
1. Создай список чисел.
2. Добавь в список 10 чисел с клавиатуры.
3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.

Пример для списка 2, 4, 4, 4, 8, 8, 9, 12, 12, 14:
3

Искомое значение равно 3, т.к. самая длинная последовательность повторяющихся чисел состоит из трех четверок.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }


        int series = 0;
        int maxSeries = 0;
        int previous = list.get(0);
        for (int i = 1; i < list.size(); i++) {
              if (previous == list.get(i)) {
                  series++;
              } else {
                  previous = list.get(i);
                  if (maxSeries < series) {
                      maxSeries = series;
                  }
                  series = 0;
                  series++;
              }
        }

        System.out.println(maxSeries);
    }
}