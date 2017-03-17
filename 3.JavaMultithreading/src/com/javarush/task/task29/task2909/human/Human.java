package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя
сеттер и геттер для доступа к averageGrade.

9.2. Замена поля-массива объектом.
Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.

9.3. Инкапсуляция поля.
Сокрой поле company в классе Worker. Добавь сеттер и геттер для него. +

9.4. Замена кодирования типа классом.

9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.

9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.

9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри
(1, 2, 3 и 4 соответственно).

9.4.4. Примени в классе Human новый тип BloodGroup..
* */

public class Human implements Alive {

    public class Size {
        public int height;
        public int weight;
    }

    private static int nextId = 0;
    protected int age;
    protected String name;
    protected Size size;
    private List<Human> children = new ArrayList<>();
    private final int id;
    private BloodGroup bloodGroup;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public String getPosition() {
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void live() {
    }


    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}