package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*Приступим к написанию клиента.
 Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера,
подсоединиться к указанному адресу, получить запрос имени от сервера,
спросить имя у пользователя, отправить имя пользователя серверу,
дождаться принятия имени сервером.
После этого клиент может обмениваться текстовыми сообщениями с сервером.
Обмен сообщениями будет происходить в двух параллельно работающих потоках.
Один будет заниматься чтением из консоли и отправкой прочитанного серверу,
 а второй поток будет получать данные от сервера и выводить их в консоль.

Начнем реализацию клиента:
1) Создай пакет client. В дальнейшем все классы, отвечающие за реализацию клиентов,
 создавай в этом пакете.
2) Создай класс Client.
3) Создай внутренний класс SocketThread унаследованный от Thread в классе Client.
Он будет отвечать за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
 Класс должен иметь публичный модификатор доступа.
4) Создай поле Connection connection в классе Client. Используй модификатор доступа,
 который позволит обращаться к этому полю из класса потомков,
 но запретит обращение из других классов вне пакета.
5) Добавь приватное поле-флаг boolean clientConnected в класс Client.
 Проинициализируй его значением false. В дальнейшем оно будет устанавливаться в true,
 если клиент подсоединен к серверу или в false в противном случае.
 При объявлении этого поля используй ключевое слово,
 которое позволит гарантировать что каждый поток, использующий поле clientConnected,
 работает с актуальным, а не кэшированным его значением.*/

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


        @Override
        public void run() {
            SocketAddress socketAddress = socket.getRemoteSocketAddress();
            ConsoleHelper.writeMessage("Connected with: " + socketAddress);
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } finally {
                if (userName != null && !userName.isEmpty() && !userName.equals("")) {
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }
            }
            ConsoleHelper.writeMessage("Connection closed." + socketAddress);
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                String data = message.getData();
                if (message.getType() == MessageType.TEXT) {
                    if (!data.isEmpty() && !data.equals("")) {
                        String text = userName + ": " + data;
                        sendBroadcastMessage(new Message(MessageType.TEXT, text));
                    }
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                String name = pair.getKey();
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST));
            Message receive = connection.receive();

            if (receive.getType().equals(MessageType.USER_NAME)) {
                String name = receive.getData();

                if (!name.isEmpty() && !name.equals("")) {
                    if (!connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    } else {
                        return serverHandshake(connection);
                    }
                } else {
                    return serverHandshake(connection);
                }

            } else {
                return serverHandshake(connection);
            }
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

