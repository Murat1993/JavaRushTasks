package com.javarush.task.task29.task2909.human;

import java.util.Date;

/*
6.1. Замена параметра набором специализированных методов. Замени метод setValue() класса
Student специализированными методами setCourse и setAverageGrade.

6.2. Добавление параметра.
Добавить параметр с типом double в метод getStudentWithAverageGrade(),
 чтобы было понятно с каким средним балом нужен студент.
Реализуй метод getStudentWithAverageGrade().

6.3. Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
Реализуй этот метод, он должен возвращать студента с максимальным средним балом.

6.4. Разделение запроса и модификатора.
Раздели метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade()
и void expel(Student student). Первый метод должен возвратить студента с минимальным
 средним балом, а второй — отчислить переданного студента (удалять из списка students).
* */

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;
    private int course;
    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void incAverageGradeBy01() {
        averageGrade += 0.1;
    }

    public void incAverageGradeBy02() {
        averageGrade += 0.2;
    }

    public void setBeginningOfSession(int day, int month, int year) {
        beginningOfSession = new Date(year, month, day);
    }

    public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}