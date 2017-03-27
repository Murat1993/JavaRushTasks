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
13.3.3. Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат вызова метода isHtmlTabSelected() из представления. Запусти приложение и убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только, когда активна закладка HTML и не доступны для закладки Текст.

14.1. Добавь в класс представления метод selectHtmlTab()+. Он должен:
14.1.1. Выбирать html вкладку (переключаться на нее).
14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.

14.2. Добавь в класс контроллера геттер для модели, в нашем случае это поле document.
14.3. Добавь в представление метод update(),
который должен получать документ у контроллера и устанавливать его в
панель редактирования htmlTextPane.
14.4. Добавь в представление метод showAbout(),
 который должен показывать диалоговое окно с информацией о программе.
 Информацию придумай сам, а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.
*/

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {

    }

    public void exit() {
        System.exit(0);
    }
}
