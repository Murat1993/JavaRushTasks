package com.javarush.task.task25.task2510;

/* 
Поживем - увидим

Все исключения, которые возникают в процессе работы нити Solution,
   должны быть обработаны одним из вариантов:

1. Если это Error, то вывести в консоль «Нельзя дальше работать«.
2. Если это Exception, то вывести в консоль «Надо обработать«.
3. Если это Throwable, то вывести в консоль «ХЗ«.
Реализуй эту логику.
*/
public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                if (throwable instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                }
                else if (throwable instanceof Exception) {
                    System.out.println("Надо обработать");
                }
                else
                {
                    System.out.println("ХЗ");
                }
            }
        });
    }


    public static void main(String[] args) {

    }
}
