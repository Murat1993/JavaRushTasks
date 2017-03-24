package com.javarush.task.task32.task3209;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*3.1. Добавь и проинициализируй поля в классе представления:

3.1.1. JTabbedPane tabbedPane — это будет панель с двумя вкладками. +

3.1.2. JTextPane htmlTextPane — это будет компонент для визуального редактирования html.
Он будет размещен на первой вкладке. +

3.1.3. JEditorPane plainTextPane — это будет компонент для редактирования html в виде текста,
 он будет отображать код html (теги и их содержимое). +

3.2. Добавь класс FrameListener в пакет listeners. Он должен:

3.2.1. Быть унаследован от WindowAdapter.

3.2.2. Иметь поле View view.

3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.

3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent),
который должен вызывать exit() у представления.
* */

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();



    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void init() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void exit() {
        controller.exit();
    }
}
