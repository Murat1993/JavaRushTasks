package com.javarush.task.task27.task2712.kitchen;


/*4. В классе Order (заказ) должна быть информация,
относящаяся к списку выбранных пользователем блюд.
Т.е. где-то должен быть список всех блюд, и должен быть список выбранных блюд в классе Order.
В классе Order нужны поля private final int number и protected List<Dish> dishes.
Конструктор должен принимать один параметр типа Tablet и инициализировать поле tablet.
* */

import com.javarush.task.task27.task2712.Tablet;

import java.util.List;

public class Order {
    final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) {
        this.tablet = tablet;
    }
}
