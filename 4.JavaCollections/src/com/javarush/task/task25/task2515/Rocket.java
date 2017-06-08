package com.javarush.task.task25.task2515;

/*
Теперь напишем класс Rocket.
Практически совпадает с классом Bomb.
Только:
а) Ракета летит вверх (т.е. y уменьшается на 1);
б) Рисуем не букву «B«, а букву «R«.


* */

public class Rocket extends BaseObject {
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    /**
     * Отрисовываем себя на холсте.
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }

    /**
     * Двигаем себя вниз на один ход.
     */
    @Override
    public void move() {
        y--;
    }
}
