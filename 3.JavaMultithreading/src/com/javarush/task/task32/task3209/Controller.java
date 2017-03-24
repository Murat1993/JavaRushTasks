package com.javarush.task.task32.task3209;

/*
* 4.1. Объяви методы initMenuBar() и initEditor() в классе View.
* Они будут отвечать за инициализацию меню и панелей редактора.

4.2. Объяви в представлении метод initGui().
Он будет инициализировать графический интерфейс.
Вызови из него инициализацию меню initMenuBar(),
 инициализацию редактора initEditor() и метод pack(),
 реализацию которого мы унаследовали от класса JFrame.
Разберись что делает метод pack().

4.3. Реализуй метод init() представления. Он должен:

4.3.1. Вызывать инициализацию графического интерфейса initGui().

4.3.2. Добавлять слушателя событий нашего окна.
В качестве подписчика создай и используй объект класса FrameListener.
 В качестве метода для добавления подписчика используй подходящий метод из
 класса Window от которого наследуется и наш класс через классы JFrame и Frame.

4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
На этом этапе приложение при запуске должно показывать окно,
которое можно растягивать, разворачивать, закрыть и т.д.*/

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public Controller(View view) {
        this.view = view;
    }

    public void init() {

    }

    public void exit() {
        System.exit(0);
    }
}
