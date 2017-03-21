package com.javarush.task.task31.task3110;

/*1. Создай класс менеджер ZipFileManager+

2. Добавь в класс приватную переменную Path zipFile.
В ней мы будем хранить полный путь к архиву, с которым будем работать.

3. Добавь конструктор ZipFileManager(Path zipFile). Проинициализируй поле класса zipFile.+

4. Объяви публичный метод createZip(Path source) throws Exception, пока с пустой реализацией.
Path source – это путь к чему-то, что мы будем архивировать.

5. Создай класс Archiver и добавь в него метод main.

6. В методе main:

6.1 Запроси пользователя ввести полный путь архива с клавиатуры.
Не забудь, что имя тоже входит в состав полного пути.

6.2 Создай объект класса ZipFileManager, передав в него имя файла архива.
 Разберись, как из String получить Path.

Подсказка: изучи метод get() класса Paths.

6.3 Запроси пользователя ввести путь к файлу, который будем архивировать.
 Не путай это с файлом архива, который мы уже ввели. На этот раз нам нужен файл,
 который мы будем сжимать, а не в котором хранить сжатые данные.

6.4 Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
* */

import java.nio.file.Path;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {

    }
}
