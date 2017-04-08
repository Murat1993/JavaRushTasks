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
        try {
            return String.valueOf(Integer.parseInt(Integer.decode(s) + "", 10));
        } catch (NumberFormatException e) {
            try {
                return String.valueOf(Integer.parseInt(Integer.decode(s) + "", 16));
            } catch (NumberFormatException e1) {
                try {
                    return String.valueOf(Integer.parseInt(Integer.decode(s) + "", 8));
                } catch (NumberFormatException e2) {
                    return String.valueOf(Integer.parseInt(Integer.decode(s) + "", 2));
                }
            }
        }
    }
}
