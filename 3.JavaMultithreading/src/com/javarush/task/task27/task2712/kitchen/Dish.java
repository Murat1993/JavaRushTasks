package com.javarush.task.task27.task2712.kitchen;

/*5. Нам нужен класс Dish(Блюдо), создадим его в пакете kitchen.
Пусть это будет enum со списком блюд: Fish, Steak, Soup, Juice, Water.
* */

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        return Fish.name() + Steak.name() + Soup.name() + Juice.name()+ Water.name();
    }
}
