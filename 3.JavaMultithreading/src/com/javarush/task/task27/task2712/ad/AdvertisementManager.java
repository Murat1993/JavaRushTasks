package com.javarush.task.task27.task2712.ad;

/*

Нам понадобится исключение, которое поможет обработать ситуацию,
если у нас не будет получаться подобрать рекламные ролики.
Нам понадобится исключение, которое поможет обработать ситуацию,
 если у нас не будет получаться подобрать рекламные ролики.


2. Разберем подробно метод void processVideos() в AdvertisementManager.

2.1. Удаляем из него вывод в консоль «calling processVideos method» +++
Метод должен:

2.2. Подобрать список видео из доступных, просмотр которых обеспечивает максимальную выгоду.
(Пока делать не нужно, сделаем позже). +++

2.3. Если нет рекламных видео, которые можно показать посетителю,
 то бросить NoVideoAvailableException, которое перехватить в оптимальном месте
 (подумать, где это место) и с уровнем Level.INFO логировать фразу
 «No video is available for the order » + order
 ++++


 2.4. Отобразить все рекламные ролики, отобранные для показа,
 в порядке уменьшения стоимости показа одного рекламного ролика в копейках.
 Вторичная сортировка — по увеличению стоимости показа одной секунды рекламного
 ролика в тысячных частях копейки.
Используйте метод Collections.sort
(Тоже пока делать не нужно, сделаем позже).

Пример для заказа [Water]:
First Video is displaying... 50, 277
где First Video — название рекламного ролика
где 50 — стоимость показа одного рекламного ролика в копейках
где 277 — стоимость показа одной секунды рекламного ролика в тысячных частях копейки (равно 0.277 коп)
Используйте методы из класса Advertisement.

2.5. В классе Advertisement создайте метод void revalidate(). Этот метод должен:
2.5.1. Бросать UnsupportedOperationException, если количество показов не положительное число.
2.5.2. Уменьшать количество показов.

* */


public class AdvertisementManager {
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() {
        if (storage.list().isEmpty())
            throw new NoVideoAvailableException();
    }
}
