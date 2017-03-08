package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        return "date_bot_" +(int) (Math.random()* 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends Client.SocketThread {

        /*1. Переопредели метод clientMainLoop():
            а) С помощью метода sendTextMessage() отправь сообщение с текстом «Привет чатику. Я бот.
            Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.»
            б) Вызови реализацию clientMainLoop() родительского класса.

        * */
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }
        /*

        2. Переопредели метод processIncomingMessage(String message).
        Он должен следующим образом обрабатывать входящие сообщения:

        а) Вывести в консоль текст полученного сообщения message.

        б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.

        в) Отправить ответ в зависимости от текста принятого сообщения.
        Если текст сообщения:

        «дата» – отправить сообщение содержащее текущую дату в формате «d.MM.YYYY«;
        «день» – в формате «d«;
        «месяц» — «MMMM«;
        «год» — «YYYY«;
        «время» — «H:mm:ss«;
        «час» — «H«;
        «минуты» — «m«;
        «секунды» — «s«.

        Указанный выше формат используй для создания объекта SimpleDateFormat.
        Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
        Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ,
        например, если Боб отправил запрос «время«,
        мы должны отправить ответ «Информация для Боб: 12:30:47«.

        Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись,
        что все работает правильно.
        Помни, что message бывают разных типов и не всегда содержат «:«*/

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText;
            String text;

            if (message != null && message.contains(": ") && !message.isEmpty()) {
                nameAndText = message.split(": ");
                text = nameAndText[1];


                Calendar calendar = new GregorianCalendar();
                SimpleDateFormat format = new SimpleDateFormat();
                String pattern = null;

                if (text != null && !text.isEmpty() && !text.equals("")) {
                    switch (text) {
                        case "дата":
                            pattern = "d.MM.YYYY";
                            break;
                        case "день":
                            pattern = "d";
                            break;
                        case "месяц":
                            pattern = "MMMM";
                            break;
                        case "год":
                            pattern = "YYYY";
                            break;
                        case "время":
                            pattern = "H:mm:ss";
                            break;
                        case "час":
                            pattern = "H";
                            break;
                        case "минуты":
                            pattern = "m";
                            break;
                        case "секунды":
                            pattern = "s";
                            break;
                    }
                }

                if (pattern != null) {
                    format.applyPattern(pattern);
                    String formattedDate = format.format(calendar.getTime());
                    sendTextMessage("Информация для "
                            + nameAndText[0] + ": " + formattedDate);
                }
            }
        }
    }
}
