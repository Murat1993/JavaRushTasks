package com.javarush.task.task29.task2909.human;


/*4.2. Извлечение суперкласса.
4.2.1. Создай класс UniversityPerson в пакете human.
4.2.2. Перенеси в него поле university.
4.2.3. Перенеси сеттер и геттер для поля university.
4.2.4. Унаследуй необходимые классы от UniversityPerson.
4.3. Замена простого поля объектом. Измени тип поля university на University.
* */

public class UniversityPerson extends Human {
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }


    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
}
