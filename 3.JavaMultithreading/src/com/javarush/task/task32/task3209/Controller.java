package com.javarush.task.task32.task3209;

/*
*Реализуй метод инициализации панелей редактора initEditor(). Он должен:

6.1. Устанавливать значение «text/html» в качестве типа контента для компонента htmlTextPane.
Найди и используй подходящий метод.

6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.

6.3. Добавлять вкладку в панель tabbedPane с именем «HTML» и компонентом из предыдущего
пункта.

6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.

6.5. Добавлять еще одну вкладку в tabbedPane с именем «Текст» и компонентом из
предыдущего пункта.

6.6. Устанавливать предпочтительный размер панели tabbedPane.

6.7. Создавать объект класса TabbedPaneChangeListener и
устанавливать его в качестве слушателя изменений в tabbedPane.

6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(),
его реализация унаследовалась от JFrame.
После запуска приложения можно будет увидеть текущие результаты:
две независимые закладки (HTML и Текст), в каждой из которых можно набирать свой текст.*/

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
