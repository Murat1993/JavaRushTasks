package com.javarush.task.task32.task3209;

/*
*12.1. Напиши реализацию класса RedoAction:
12.1.1. Добавь в класс поле View. Добавь его инициализацию в конструкторе.

12.1.2. Реализуй метод actionPerformed(ActionEvent actionEvent),
он должен вызывать метод redo() у представления.

12.2. Напиши реализацию класса UndoAction по аналогии с RedoAction.

12.3. Изучи реализацию класса StrikeThroughAction,
которую ты получил вместе с заданием и реализуй аналогичным образом классы:

12.3.1. SubscriptAction

12.3.2. SuperscriptAction
Запусти программу и убедись, что пункты меню Подстрочный знак,
Надстрочный знак и Зачеркнутый работают. Пункты,
отвечающие за отмену и возврат действия пока не подключены к контроллеру и
мы не сможем их проверить.*/

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
