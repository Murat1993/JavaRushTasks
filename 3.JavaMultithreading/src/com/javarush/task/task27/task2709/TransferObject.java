package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        if (isValuePresent) {
            System.out.println("Got: " + value);
            isValuePresent = false;
            notify();
            return value;
        } else {
            try {
                while (!isValuePresent) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Got: " + value);
            isValuePresent = false;
            notify();
            return value;
        }
    }

    public synchronized void put(int value) {
        if (isValuePresent) {
            while (isValuePresent) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.value = value;
            notify();
        }
        this.value = value;
        isValuePresent = true;
        notify();
        System.out.println("Put: " + value);
    }
}
