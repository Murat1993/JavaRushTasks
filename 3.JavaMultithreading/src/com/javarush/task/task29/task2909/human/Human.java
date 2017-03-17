package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент
создания объекта.

8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с
областью его использования.

8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы
он удалял студента из списка студентов только, если он там есть. Метод не должен кидать
исключение.

8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его
работы. В методе не должны использоваться флаги типа found, воспользуйся оператором
break.
* */

public class Human implements Alive {
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private static int nextId = 0;
    protected int age;
    protected String name;
    protected int[] size;
    private List<Human> children = new ArrayList<>();
    private final int id;
    private int bloodGroup;

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

    public void printSize() {
        System.out.println("Рост: " + size[0] + " Вес: " + size[1]);
    }
}