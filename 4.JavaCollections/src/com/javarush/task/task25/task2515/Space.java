package com.javarush.task.task25.task2515;

/*
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу, куда мы будем рисовать.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).

Надо:
а) Добавить в класс две переменные width и height;
б) Добавить в класс переменную matrix (char[][]);
в) Добавь геттеры для них;
г) В конструкторе проинициализируй матрицу.


* */

import java.util.ArrayList;

public class Space {

    private int width;
    private int height;
    private SpaceShip ship;
    private ArrayList<Ufo> ufos = new ArrayList<>();
    private ArrayList<Rocket> rockets = new ArrayList<>();
    private ArrayList<Bomb> bombs = new ArrayList<>();
    public static Space game;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }

    public void run() {

    }

    public void draw() {

    }

    public void sleep(int ms) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    public ArrayList<Ufo> getUfos() {
        return ufos;
    }

    public ArrayList<Rocket> getRockets() {
        return rockets;
    }

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }
}
