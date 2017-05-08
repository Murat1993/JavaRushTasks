package com.javarush.task.task32.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
Привет Амиго. Ты знаешь, за нами следят, просматривают нашу переписку.
Поэтому нужно шифровать трафик.
Для тебя не составит труда реализовать шифр Цезаря,
напомню что это просто сдвиг вправо по алфавиту на key букв.
В методе main есть хороший пример.

Реализуй логику метода String decode(StringReader reader, int key).
Метод получает данные в закодированном виде.
Он должен вернуть дешифрованную строку, что хранится в StringReader — е.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("   Khoor Dpljr");
        System.out.println(decode(reader, -55));  //Hello Amigo

    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder builder = new StringBuilder();
        int upLimitUpperCase = 90;
        int downLimitUpperCase = 65;

        int upLimitDownCase = 122;
        int downLimitDownCase = 97;

        int character;
        int step;
        if (reader != null) {
            while ((character = reader.read()) != -1) {
                if (character == ' ') {
                    builder.append(" ");
                    continue;
                }
                else if (character >= downLimitUpperCase && character <= upLimitUpperCase) {
                    if (character + key < downLimitUpperCase) {
                        step = downLimitUpperCase - (character + key);
                        character = upLimitUpperCase - step;
                    } else if (character + key > upLimitUpperCase) {
                        step = (character + key) - upLimitUpperCase;
                        character = downLimitUpperCase + step;
                    } else {
                        character += key;
                    }
                }

                else if (character <= upLimitDownCase && character >= downLimitDownCase) {
                    if (character + key < downLimitDownCase) {
                        step = downLimitDownCase - (character + key);
                        character = upLimitDownCase - step;
                    } else if (character + key > upLimitDownCase) {
                        step = (character + key) - upLimitDownCase;
                        character = downLimitDownCase + step;
                    } else {
                        character = character + key;
                    }
                }

                builder.append((char) character);
            }
        }
        return builder.toString();
    }

}
