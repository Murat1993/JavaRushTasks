package com.javarush.task.task27.task2712;

/*

2. Добавим возможность посчитать продолжительность приготовления всего заказа.
Куда его добавить???

2.1. Если в класс Cook, то повар сможет считать продолжительность приготовления заказа.
Чтобы другие классы могли получить эту информацию,
необходимо будет получить доступ к объекту Cook.

2.2. Если в класс Order, то имея доступ к заказу всегда можно
 узнать продолжительность приготовления.

2.3. Выбери правильное место из п.2.1. и п.2.2. и добавьте метод pubic int getTotalCookingTime(),
 который посчитает суммарное время приготовления всех блюд в заказе.

2.4. Добавим нашему повару вывод в консоль этой информации.
Пусть теперь выводится аналогичное сообщение:
Start cooking — Your order: [Soup, Juice, Water] of Tablet{number=5}, cooking time 23min


Наведем красоту:
3. Запустим приложение и сразу введем ‘exit‘.
Вывод получился не очень красивым.
Сделай так, чтобы если в заказе нет блюд, он не отправлялся повару.
 Найди это место и реализуйте логику.
В классе Order создай вспомогательный метод public boolean isEmpty(), который будет определять,
 есть ли какие либо блюда в заказе.


* */

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook amigo = new Cook("Amigo");
        amigo.addObserver(new Waiter());
        tablet.addObserver(amigo);
        tablet.createOrder();
    }
}
