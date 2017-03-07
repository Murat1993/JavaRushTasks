package com.javarush.task.task30.task3008;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
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

