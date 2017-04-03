package com.javarush.task.task27.task2712.ad;

/*

2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число. +
2.5.2. Уменьшать количество показов. +

* */

public class Advertisement {

    private Object content;
    private String name;
    private long initialAmount; //  начальная сумма, стоимость рекламы в копейках
    private int hits;           // количество оплаченных показов
    private int duration;       // продолжительность ролика в секундах
    private long amountPerOneDisplaying; // стоимость одного показа рекламного объявления в копейках

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
    }

    public void revalidate() {
        if (hits <= 0) {
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }
}
