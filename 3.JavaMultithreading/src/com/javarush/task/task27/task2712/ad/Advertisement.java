package com.javarush.task.task27.task2712.ad;

/*2. Создадим класс Advertisement(Рекламное объявление) в пакете ad,
у которого будут следующие поля:
Object content — видео
String name — имя/название
long initialAmount — начальная сумма, стоимость рекламы в копейках.
Используем long, чтобы избежать проблем с округлением
int hits — количество оплаченных показов
int duration — продолжительность в секундах
Модификаторы доступа расставь самостоятельно.

3. В классе Advertisement создадим конструктор с порядком аргументов,
 соответствующим перечисленной последовательности всех полей класса

 4. В этом же пакете создадим еще два класса:
AdvertisementStorage — хранилище рекламных роликов.
AdvertisementManager — у каждого планшета будет свой объект менеджера,
который будет подбирать оптимальный набор роликов и их последовательность для каждого заказа.
Он также будет взаимодействовать с плеером и отображать ролики.

5. Так как хранилище рекламных роликов AdvertisementStorage единственное для всего ресторана,
 то сделаем его синглтоном.


1. В классе Advertisement создай поле long amountPerOneDisplaying.
Оно должно равняться стоимости одного показа рекламного объявления в копейках (initialAmount/hits).
Присвой значение полю в конструкторе.

2. В классе Advertisement создай геттеры для полей name, duration и amountPerOneDisplaying.

* */

public class Advertisement {

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount / hits;
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
