package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Мы много работаем с консолью. Пора создать единую точку взаимодействия.
Создай класс ConsoleHelper с единственным BufferedReader, через который будем работать с консолью.
Запомни, этот класс не хранит никаких данных и состояний, поэтому все методы будут статическими.
Создай в нем три метода:
— writeMessage(String message) — для вывода message в консоль
— String readString() — для чтения строки с консоли
— List<Dish> getAllDishesForOrder() — просит пользователя выбрать блюдо и добавляет его в список.
Выведи список всех блюд и попроси пользователя ввести строку — название блюда.
Введенное ‘exit‘ означает завершение заказа.
В случае, если введенное блюдо не представлено в меню, выведи сообщение о том,
что такого блюда нет и продолжи формирование заказа.
Исключения ввода-вывода бросай выше, на этом уровне не понятно, что с ними делать.
* */

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        for (Dish dish : Dish.values()) {
            writeMessage(dish.toString());
        }

        writeMessage("Please, select dish: ");

        while (true) {
            String order = readString();
            if (order.equals("exit"))
                break;
            boolean weHaveIt = false;
            for (Dish dish : Dish.values()) {
                if (dish.toString().equals(order)) {
                    weHaveIt = true;
                    break;
                }
            }

            if (weHaveIt) {
                dishes.add(Dish.valueOf(order));
            } else {
                writeMessage("I'm sorry, we don't have that kind of dish.");
            }
        }

        return dishes;
    }
}
