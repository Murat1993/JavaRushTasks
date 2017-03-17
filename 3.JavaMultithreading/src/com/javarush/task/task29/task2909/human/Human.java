package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
3.1. Спуск поля. Спусти поле course в соответствующий класс. Сделай его приватным.
3.2. Спуск метода. Спусти геттер для поля course в соответствующий класс.

3.3. Извлечение интерфейса.
3.3.1. Создай интерфейс Alive (живой) в пакете human.
3.3.2. Интерфейс должен содержать метод жить live().
3.3.3. Добавь интерфейс нужному классу.
3.4. Свертывание иерархии. Избавься от класса Professor.
* */

public class Human implements Alive {
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    public static int nextId = 0;
    protected int age;
    protected String name;
    protected int[] size;
    private List<Human> children = new ArrayList<>();
    private int id;
    private int bloodGroup;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
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

    public int getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(int code) {
        bloodGroup = code;
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

    public void setId(int id) {
        this.id = id;
    }

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}