package com.javarush.task.task32.task3209;

/*
*Пришло время добавить все необходимые пункты меню и написать классы действий,
 *  выполняемые при нажатии. Это довольно трудоемкая и рутинная работа,
 *  а ты отличный ученик и не хотелось бы тебя огорчать.
 *  Поэтому, в качестве бонуса ты получаешь готовый класс MenuHelper! А ты:
 *
8.1. Напиши в пакете actions заглушки для следующих классов:

8.1.1. Класс отмены действия UndoAction.
Он должен наследоваться от AbstractAction и содержать конструктор UndoAction(View view).

8.1.2. Класс возврата действия RedoAction. Требования аналогичны требованиям к UndoAction.

8.1.3. Класс StrikeThroughAction, который отвечает за стиль текста «Зачеркнутый«.
Унаследуй его от StyledEditorKit.StyledTextAction.

8.1.4. Класс SubscriptAction, который отвечает за стиль текста «Подстрочный знак«.
Его также унаследуй его от StyledEditorKit.StyledTextAction.

8.1.5. Класс SuperscriptAction. Он будет отвечать за стиль «Надстрочный знак«.
Добавь ему правильный родительский класс.
+

8.2. Напиши в пакете listeners заглушки для классов:

8.2.1. UndoMenuListener, он должен реализовывать интерфейс MenuListener
 и иметь конструктор UndoMenuListener(View view, JMenuItem undoMenuItem,
 JMenuItem redoMenuItem). Чем он будет заниматься узнаешь чуть позже.

8.2.2. TextEditMenuListener. Этот класс также должен реализовывать интерфейс MenuListener.
Добавь ему конструктор TextEditMenuListener(View view).
 В следующих заданиях мы рассмотрим его детальнее.*/

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
