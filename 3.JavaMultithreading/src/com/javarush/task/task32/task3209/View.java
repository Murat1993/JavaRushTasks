package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.javarush.task.task32.task3209.MenuHelper.*;

/*
11.1. Добавь в представление поле UndoManager undoManager. +
Разберись для чего используется этот класс. Проинициализируй поле класса новым объектом. +

11.2. Добавь класс UndoListener реализующий интерфейс UndoableEditListener в пакет listeners.
Этот класс будет следить за правками, которые можно отменить или вернуть. +

11.3. Добавь в класс UndoListener:
11.3.1. Поле UndoManager undoManager.
11.3.2. Конструктор, который принимает UndoManager и инициализирует поле класса.
11.3.3. Метод undoableEditHappened(UndoableEditEvent e).
Он должен из переданного события получать правку и добавлять ее в undoManager.

11.4. Добавь в представление поле UndoListener undoListener,
проинициализируй его используя undoManager.






11.5. Добавь в представление методы:
11.5.1. void undo() — отменяет последнее действие. Реализуй его используя undoManager.
Метод не должен кидать исключений, логируй их.

11.5.2. void redo() — возвращает ранее отмененное действие.
Реализуй его по аналогии с предыдущим пунктом.

11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager. +
11.5.4. Реализуй геттер для undoListener. +
11.5.5. Добавь и реализуй метод void resetUndo(),
который должен сбрасывать все правки в менеджере undoManager. +

*/

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextPane htmlTextPane = new JTextPane();
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
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

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }
}
