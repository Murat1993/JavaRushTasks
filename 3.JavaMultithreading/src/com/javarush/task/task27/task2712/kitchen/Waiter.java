package com.javarush.task.task27.task2712.kitchen;

/*1.
Создадим класс Waiter(Официант) в пакете kitchen, он будет относить заказы назад к столику.
Официант будет безымянным.

2. Cook(Повар) готовит заказы, а Waiter их обрабатывает.
Расставь правильно Observer и Observable между Waiter и Cook.

3. Метод void update будет выводить в консоль сообщение о том,
какой заказ и кем был приготовлен:

order + " was cooked by " + cook

4. В классе наследнике Observable перед отправкой заказа сделаем следующее:

4.1. Установим флаг setChanged()

4.2. Отправим наблюдателю заказ - notifyObservers(order);

5. Пишем main.

Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia

Называем повара, имя не влияет на тесты. В моем варианте - это Amigo :)

Сверим выводы в консоль. Пример моего вывода:

Your order: [Water] of Tablet{number=5}

Start cooking - Your order: [Water] of Tablet{number=5}

Your order: [Water] of Tablet{number=5} was cooked by Amigo
* */

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

public class Waiter implements Observer {
    @Override
    public void update(Observable cook, Object order) {
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
    }
}
