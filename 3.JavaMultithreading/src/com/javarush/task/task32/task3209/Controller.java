package com.javarush.task.task32.task3209;

/*
* Графический интерфейс будет представлять собой окно, в котором будет меню и панель с
двумя вкладками.
На первой вкладке будет располагаться текстовая панель,
которая будет отрисовывать html страницу. На ней можно будет форматировать и редактировать текст страницы.
На второй вкладке будет редактор, который будет отображать код html страницы,
в нем будут видны все используемые html теги. В нем также можно будет менять текст страницы,
добавлять и удалять различные теги.

3.1. Добавь и проинициализируй поля в классе представления:

3.1.1. JTabbedPane tabbedPane — это будет панель с двумя вкладками.

3.1.2. JTextPane htmlTextPane — это будет компонент для визуального редактирования html.
Он будет размещен на первой вкладке.

3.1.3. JEditorPane plainTextPane — это будет компонент для редактирования html в виде текста,
 он будет отображать код html (теги и их содержимое).

3.2. Добавь класс FrameListener в пакет listeners. Он должен:

3.2.1. Быть унаследован от WindowAdapter.

3.2.2. Иметь поле View view.

3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.

3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent),
который должен вызывать exit() у представления.*/

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
