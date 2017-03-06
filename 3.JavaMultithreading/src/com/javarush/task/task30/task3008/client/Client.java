package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

/*
* Приступим к написанию главного функционала класса Client.

1. Добавь метод void run(). Он должен создавать вспомогательный поток SocketThread,
ожидать пока тот установит соединение с сервером,
а после этого в цикле считывать сообщения с консоли и отправлять их серверу.
Условием выхода из цикла будет отключение клиента или ввод пользователем команды ‘exit‘.
Для информирования главного потока, что соединение установлено во
вспомогательном потоке, используй методы wait и notify объекта класса Client.

Реализация метода run должна:
а) Создавать новый сокетный поток с помощью метода getSocketThread.
б) Помечать созданный поток как daemon, это нужно для того,
чтобы при выходе из программы вспомогательный поток прервался автоматически.
в) Запустить вспомогательный поток.
г) Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока.
Подсказка: используй wait и синхронизацию на уровне объекта.
Если во время ожидания возникнет исключение, сообщи об этом пользователю и выйди из программы.
д) После того, как поток дождался нотификации, проверь значение clientConnected.
 Если оно true – выведи «Соединение установлено. Для выхода наберите команду ‘exit’.«.
 Если оно false – выведи «Произошла ошибка во время работы клиента.».
е) Считывай сообщения с консоли пока клиент подключен. Если будет введена команда ‘exit‘,
 то выйди из цикла.
ж) После каждого считывания, если метод shouldSendTextFromConsole() возвращает true,
отправь считанный текст с помощью метода sendTextMessage().

2. Добавь метод main().
Он должен создавать новый объект типа Client и вызывать у него метод run().*/

public class Client {

    private volatile boolean clientConnected = false;
    protected Connection connection;

    public class SocketThread extends Thread {

    }

    protected String getServerAddress() {
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
