package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.

2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Throwable cause = e;
        ArrayList<Throwable> list = new ArrayList<>();
        list.add(cause);
        while (cause != null) {
            cause = cause.getCause();
            if (cause != null) {
                list.add(cause);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

    }

    public static void main(String[] args) {

    }
}
