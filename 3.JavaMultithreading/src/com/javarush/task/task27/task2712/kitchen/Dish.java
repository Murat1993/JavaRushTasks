package com.javarush.task.task27.task2712.kitchen;

/*5. Нам нужен класс Dish(Блюдо), создадим его в пакете kitchen.
Пусть это будет enum со списком блюд: Fish, Steak, Soup, Juice, Water.

1. Предположим, что нам известно время приготовления каждого блюда в минутах.
Захардкодим его в классе Dish.
1.1. Измени создание элементов enum — Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
1.2. Создай поле private int duration с геттером.
Чтобы создать геттер, нажмите Alt+Insert и выберите пункт Getter.
 Далее выберите имя поля и нажмите OK(Enter).

* */

public enum Dish {

    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int i) {
        duration = i;
    }

    public static String allDishesToString() {
        return Fish.name() + Steak.name() + Soup.name() + Juice.name() + Water.name();
    }

    public int getDuration() {
        return duration;
    }
}
