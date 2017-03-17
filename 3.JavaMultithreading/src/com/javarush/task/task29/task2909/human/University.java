package com.javarush.task.task29.task2909.human;


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

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                return student;
            }
        }
        return null;
    }

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