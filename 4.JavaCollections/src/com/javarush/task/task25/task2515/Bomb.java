package com.javarush.task.task25.task2515;

/*
Теперь напишем класс Bomb. Тут все просто.
Bomb унаследован от BaseObject.

Надо:
а) изменить конструктор:
Конструктор Bomb должен выглядеть примерно так:
public Bomb(double x, double y)
{
super(x, y, 1);
}

x и y переданные в конструктор Bomb мы передаем дальше в конструктор BaseObject с помощью super,
 где так же указываем радиус «бомбы» равный 1.

б) написать метод move():
тут все просто — бомба падает вниз — просто увеличиваем y на 1.

в) метод draw(Canvas canvas):
тут тоже не очень сложная логика.
Давай просто ставить точку с координатами (x,y) и «цветом» B:
canvas.setPoint(x,y,’B’).

г) Создай в классе Space нашу игру public static Space game.
* */

public class Bomb extends BaseObject {
    public Bomb(double x, double y, double radius) {
        super(x, y, radius);
    }
}
