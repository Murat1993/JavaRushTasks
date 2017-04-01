package com.javarush.task.task27.task2712;

/*

3. Пишем main.
Для объекта Observable добавляем свой объект Observer. См. п.2 и описание паттерна в wikipedia
Называем повара, имя не влияет на тесты. В моем варианте — это Amigo : )

Сверим выводы в консоль. Пример моего вывода:
Your order: [Soup] of Tablet{number=5}
Start cooking - Your order: [Soup] of Tablet{number=5}

4. Не забудь сразу после создания заказа и вывода информации о нем в консоль
(найдите это место в коде) сделать следующее:
4.1. Установить флаг setChanged()
4.2. Отправить обсерверу заказ — notifyObservers(order); +

5. Также внесем небольшое изменение.
Сделай так чтобы метод createOrder возвращал текущий заказ или null,
если заказ создать не удалось.

* */

import com.javarush.task.task27.task2712.kitchen.Cook;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook amigo = new Cook("Amigo");
        tablet.addObserver(amigo);
        tablet.createOrder();
    }
}
