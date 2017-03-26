package com.javarush.task.task32.task3209;

/*
*Реализуем класс TextEditMenuListener в пакет listeners.
 *  Этот класс будет работать аналогично классу UndoMenuListener только для других пунктов меню.
  *  Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда,
  *  когда в нашем редакторе выбрана первая вкладка.
  *
13.1. Добавь в представление метод boolean isHtmlTabSelected().
Он должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
13.2. Добавь в класс TextEditMenuListener поле View, проинициализируй его в конструкторе класса.
13.3. В классе TextEditMenuListener переопредели метод menuSelected(MenuEvent menuEvent). Он должен:
13.3.1. Из переданного параметра получать объект, над которым было совершено действие. В нашем случае это будет объект с типом JMenu.
13.3.2. У полученного меню получать список компонентов (пунктов меню).
13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова метода isHtmlTabSelected() из представления. Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только, когда активна закладка HTML и не доступны для закладки Текст.*/

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
