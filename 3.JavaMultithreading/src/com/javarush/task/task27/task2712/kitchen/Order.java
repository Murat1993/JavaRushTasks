package com.javarush.task.task27.task2712.kitchen;


/*

3. Вернемся к классу Order: в нем есть ссылка на планшет, и еще есть список выбранных блюд.
Инициализируй список dishes в конструкторе, вызвав метод getAllDishesForOrder из ConsoleHelper.+

4. Перепиши метод toString в классе Order. Пусть он возвращает пустую строку,
если нет блюд в заказе, иначе вывод должен быть аналогичным примеру в порядке добавления блюд.
 Используй ConsoleHelper.
Также измени метод toString в классе Tablet (внутри класса Tablet нажмите Alt+Insert -> toString()).
Пример:
Your order: [Juice, Fish] of Tablet{number=5}

* */

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
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
