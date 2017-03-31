package com.javarush.task.task27.task2712;

/*5. У нас все завязано на работу с консолью.
Однако, при возникновении исключений, наше приложение умрет.
Чтобы узнать причину — добавим в Tablet статическое поле logger типа java.util.logging.Logger,
 инициализированное именем класса (Logger.getLogger(Tablet.class.getName())). +

6. В методе createOrder класса Tablet обработаем исключения ввода-вывода.
Запишем в лог «Console is unavailable.«. Уровень лога — SEVERE — это самый серьезный уровень,
 мы не можем работать.
Также в методе createOrder класса Tablet должен быть создан новый заказ.
* */

import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    public final int number;

    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Tablet{" +
                "number=" + number +
                '}';
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }
}
