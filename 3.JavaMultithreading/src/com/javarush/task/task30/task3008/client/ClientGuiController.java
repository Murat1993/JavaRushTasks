package com.javarush.task.task30.task3008.client;

/*
У меня есть отличнейшая новость для тебя. Компонент представление (View) уже готов.
Я добавил класс ClientGuiView. Он использует библиотеку javax.swing.
Ты должен как следует разобраться в каждой строчке этого класса.
 Если тебе все понятно – это замечательно,
 если нет – обязательно найди ответы на свои вопросы с помощью дебага,
 документации или поиска в Интернет.

Осталось написать компонент контроллер (Controller):
1. Создай класс ClientGuiController унаследованный от Client. +

2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model. +

3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view.
Подумай, что нужно передать в конструктор при инициализации объекта. +

4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread. +
Класс GuiSocketThread должен быть публичным. В нем переопредели следующие методы:

а) void processIncomingMessage(String message) –
должен устанавливать новое сообщение у модели и вызывать
обновление вывода сообщений у представления.

б) void informAboutAddingNewUser(String userName) –
должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.

в) void informAboutDeletingNewUser(String userName) –
должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.

г) void notifyConnectionStatusChanged(boolean clientConnected) –
должен вызывать аналогичный метод у представления.


5. Переопредели методы в классе ClientGuiController:
а) SocketThread getSocketThread() – должен создавать и возвращать объект типа GuiSocketThread. +

б) void run() –
должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
 Разберись, почему нет необходимости вызывать метод run в отдельном потоке,
 как мы это делали для консольного клиента.

в) getServerAddress(), getServerPort(), getUserName().
Они должны вызывать одноименные методы из представления (view).

6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.

7. Реализуй метод main(),
который должен создавать новый объект ClientGuiController и вызывать у него метод run().

Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
все работает корректно.
* */

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public static void main(String[] args) {
        ClientGuiController controller = new ClientGuiController();
        controller.run();
    }

    public ClientGuiModel getModel() {
        return model;
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public class GuiSocketThread extends SocketThread {
/*
        а) void processIncomingMessage(String message) –
        должен устанавливать новое сообщение у модели и вызывать
        обновление вывода сообщений у представления.

                б) void informAboutAddingNewUser(String userName) –
        должен добавлять нового пользователя в модель и
        вызывать обновление вывода пользователей у отображения.

                в) void informAboutDeletingNewUser(String userName) –
        должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.

        г) void notifyConnectionStatusChanged(boolean clientConnected) –
        должен вызывать аналогичный метод у представления.*/

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

}
