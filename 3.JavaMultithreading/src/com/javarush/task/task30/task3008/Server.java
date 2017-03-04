package com.javarush.task.task30.task3008;


/*
Т.к. сервер может одновременно работать с несколькими клиентами, нам понадобится
метод для отправки сообщения сразу всем.

Добавь в класс Server:
1. Статическое поле Map<String, Connection> connectionMap, где ключом будет имя
клиента, а значением — соединение с ним. +

2. Инициализацию поля из п.7.1 с помощью подходящего Map из библиотеки
java.util.concurrent, т.к. работа с этим полем будет происходить из разных потоков и
нужно обеспечить потокобезопасность. +

3. Статический метод void sendBroadcastMessage(Message message), который должен
отправлять сообщение message всем соединениям из connectionMap. Если при
отправке сообщение произойдет исключение IOException, нужно отловить его и
сообщить пользователю, что не смогли отправить сообщение.


*/

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry pair : connectionMap.entrySet()) {
            Connection connection = (Connection) pair.getValue();
            try {
                connection.send(message);
            } catch (IOException e) {
                try {
                    connection.send(new Message(MessageType.TEXT, "Can't send message!"));
                } catch (IOException e1) {
                    continue;
                }
                return;
            }
        }
    }


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }

    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);

        ConsoleHelper.writeMessage("Server is started!");

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
}
