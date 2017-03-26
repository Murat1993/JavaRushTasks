package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.javarush.task.task32.task3209.MenuHelper.*;


public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void init() {
        initGui();
        FrameListener listener = new FrameListener(this);
        this.addWindowListener(listener);
        this.setVisible(true);
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    /*9.1. Реализуй метод initMenuBar(). Он должен:

9.1.1. Создавать новый объект типа JMenuBar. Это и будет наша панель меню. +

9.1.2. С помощью MenuHelper инициализировать меню в следующем порядке: Файл,
Редактировать, Стиль, Выравнивание, Цвет, Шрифт и Помощь.

9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню,
аналогично тому, как это мы делали с панелью вкладок.

6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(),
его реализация унаследовалась от JFrame.
После запуска приложения можно будет увидеть текущие результаты:
две независимые закладки (HTML и Текст),
в каждой из которых можно набирать свой текст.


9.2. Добавь конструктор класса View.
Он должен устанавливать внешний вид и поведение (look and feel) нашего приложения такими же,
как это определено в системе.
Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.

Подсказа: для реализации задания используй класс UIManager.

Запусти приложение, теперь ты должен видеть панель с меню вверху окна.
Некоторые из пунктов меню (например: Вырезать, Копировать, Вставить, Стиль (частично),
Выравнивание, Цвет, Шрифт) должны уже работать.
Убедись, что все работает и только затем продолжи разработку.

    * */

    public void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        initFileMenu(this, menuBar);
        initEditMenu(this, menuBar);
        initStyleMenu(this, menuBar);
        initAlignMenu(this, menuBar);
        initColorMenu(this, menuBar);
        initFontMenu(this, menuBar);
        initHelpMenu(this, menuBar);
        getContentPane().add(menuBar, BorderLayout.NORTH);
    }

    /*6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(),
 его реализация унаследовалась от JFrame.
После запуска приложения можно будет увидеть текущие результаты:
две независимые закладки (HTML и Текст),
 в каждой из которых можно набирать свой текст.
    * */

    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));
        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));
        tabbedPane.setPreferredSize(new Dimension(300, 300));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void selectedTabChanged() {

    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void exit() {
        controller.exit();
    }
}
