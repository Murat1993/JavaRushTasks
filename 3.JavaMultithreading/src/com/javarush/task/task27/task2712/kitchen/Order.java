package com.javarush.task.task27.task2712.kitchen;


import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/*2.3. Выбери правильное место из п.2.1. и п.2.2. и добавьте метод pubic int getTotalCookingTime(),
 который посчитает суммарное время приготовления всех блюд в заказе.

2.4. Добавим нашему повару вывод в консоль этой информации.
Пусть теперь выводится аналогичное сообщение:
Start cooking — Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min
* */

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {
        int total = 0;
        for (Dish dish : dishes) {
            total += dish.getDuration();
        }
        return total;
    }

    @Override
    public String toString() {
        if (dishes.isEmpty()) {
            return "";
        }
        return "Your order: " +
                dishes.toString() +
                " of " + tablet;
    }
}
