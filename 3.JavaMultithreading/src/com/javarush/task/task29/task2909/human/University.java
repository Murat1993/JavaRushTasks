package com.javarush.task.task29.task2909.human;


/*
4.1. Замена наследования делегированием.
4.1.1. Класс University не должен наследоваться от Student.
4.1.2. Класс University должен содержать список students. Не забудь его инициализировать.
4.1.3. Добавь сеттер и геттер для students.
4.1.4. Университет имеет название (name) и возраст (age). Добавь необходимые поля,
сеттеры и геттеры для них.

4.2. Извлечение суперкласса.
4.2.1. Создай класс UniversityPerson в пакете human.
4.2.2. Перенеси в него поле university.
4.2.3. Перенеси сеттер и геттер для поля university.
4.2.4. Унаследуй необходимые классы от UniversityPerson.
4.3. Замена простого поля объектом. Измени тип поля university на University.
* */

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /*
    6.2. Добавление параметра.
    Добавить параметр с типом double в метод getStudentWithAverageGrade(),
    чтобы было понятно с каким средним балом нужен студент.
    Реализуй метод getStudentWithAverageGrade().*/

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }
/*
    6.3. Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
    Реализуй этот метод, он должен возвращать студента с максимальным средним балом.*/

    public Student getStudentWithMaxAverageGrade() {
        double maxAverage = students.get(0).getAverageGrade();
        Student studentWithMaxAverage = null;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAverage) {
                maxAverage = student.getAverageGrade();
                studentWithMaxAverage = student;
            }
        }
        return studentWithMaxAverage;
    }
/*
    6.4. Разделение запроса и модификатора.
    Раздели метод getStudentWithMinAverageGradeAndExpel
    на Student getStudentWithMinAverageGrade()
    и void expel(Student student). Первый метод должен возвратить студента с минимальным
    средним балом, а второй — отчислить переданного студента (удалять из списка students).*/

    public Student getStudentWithMinAverageGrade() {
        double minAverage = students.get(0).getAverageGrade();
        Student studentWithMinAverage = null;
        for (Student student : students) {
            if (student.getAverageGrade() < minAverage) {
                minAverage = student.getAverageGrade();
                studentWithMinAverage = student;
            }
        }
        return studentWithMinAverage;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}