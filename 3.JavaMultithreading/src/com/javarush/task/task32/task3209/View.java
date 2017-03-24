package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
4.3. Реализуй метод init() представления. Он должен:

4.3.1. Вызывать инициализацию графического интерфейса initGui().

4.3.2. Добавлять слушателя событий нашего окна.
В качестве подписчика создай и используй объект класса FrameListener.
 В качестве метода для добавления подписчика используй подходящий метод из
 класса Window от которого наследуется и наш класс через классы JFrame и Frame.

4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
На этом этапе приложение при запуске должно показывать окно,
которое можно растягивать, разворачивать, закрыть и т.д.


* */

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

    public void initEditor() {

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
