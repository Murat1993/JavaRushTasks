package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();

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

    public void initMenuBar() {

    }
    /*Реализуй метод инициализации панелей редактора initEditor(). Он должен:

6.1. Устанавливать значение «text/html» в качестве типа контента для компонента htmlTextPane.
Найди и используй подходящий метод. +

6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane. +

6.3. Добавлять вкладку в панель tabbedPane с именем «HTML» и компонентом из предыдущего
пункта. +

6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.

6.5. Добавлять еще одну вкладку в tabbedPane с именем «Текст» и компонентом из
предыдущего пункта. +

6.6. Устанавливать предпочтительный размер панели tabbedPane.

6.7. Создавать объект класса TabbedPaneChangeListener и
устанавливать его в качестве слушателя изменений в tabbedPane.

6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
Получить панель контента текущего фрейма можно с помощью метода getContentPane(),
его реализация унаследовалась от JFrame.
После запуска приложения можно будет увидеть текущие результаты:
две независимые закладки (HTML и Текст), в каждой из которых можно набирать свой текст.
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
