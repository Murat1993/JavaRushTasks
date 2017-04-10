package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem,
 который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код

        if (s.startsWith("0X") || s.startsWith("0x")) {
            return String.valueOf(Integer.parseInt(String.valueOf(Integer.decode(s)), 10));

        }

        if (s.startsWith("0B") || s.startsWith("0b" )) {
            return String.valueOf(Integer.parseInt(s, 10));
        }
        return "";
    }
}
