package com.javarush.task.task29.task2909.user;


/*Разберись с кодом пакета user (пользователь).

13.1. Извлечение метода.
Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль в формате

Имя: Вася
Фамилия: Пупкин

Замени повторяющийся код метода printUsers() его вызовом. +

13.2. Встраивание метода.
Избавься от метода ageLessThan16().

13.3. Перемещение метода.
Перемести методы printInfo() и printAdditionalInfo() в класс User.+

13.4. Расщепление переменной.
Переменная age в методе calculateAverageAge() используется для разных промежуточных значений.
Перепиши метод без использования этой переменной. +


13.5. Удаление присваиваний параметрам.
 Перепиши метод calculateRate(), чтобы он не
пытался менять входные параметры, а просто возвращал рассчитанное значение.
* */

public class User {
    private String name;
    private String surname;
    private int age;

    private String country;
    private String city;
    private House house;

    private Work work;

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Имя: " + getName());
        System.out.println("Фамилия: " + getSurname());
    }


    public void printAdditionalInfo() {
        if (getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return country + " " + city + " " + house.house;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}