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
Реализуем метод actionPerformed(ActionEvent actionEvent) у представления,
этот метод наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню,
 у которых наше представление указано в виде слушателя событий.

19.1. Получи из события команду с помощью метода getActionCommand().
Это будет обычная строка. По этой строке ты можешь понять какой пункт меню создал данное событие.

19.2. Если это команда «Новый«, вызови у контроллера метод createNewDocument().
В этом пункте и далее, если необходимого метода в контроллере еще нет — создай заглушки.

19.3. Если это команда «Открыть«, вызови метод openDocument().
19.4. Если «Сохранить«, то вызови saveDocument().
19.5. Если «Сохранить как…» — saveDocumentAs().
19.6. Если «Выход» — exit().
19.7. Если «О программе«, то вызови метод showAbout() у представления.
Проверь, что заработали пункты меню Выход и О программе.

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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command) {
            case "Новый":
                controller.createNewDocument();
                break;
            case "Открыть":
                controller.openDocument();
                break;
            case "Сохранить":
                controller.saveDocument();
                break;
            case "Сохранить как...":
                controller.saveDocumentAs();
                break;
            case "Выход":
                controller.exit();
                break;
            case "О программе":
                showAbout();
                break;

        }

    }

    public void selectedTabChanged() {
        int index = tabbedPane.getSelectedIndex();
        switch (index) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                this.resetUndo();
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                this.resetUndo();
                break;
        }
    }

    public void showAbout() {
        JOptionPane.showMessageDialog(tabbedPane, "something", "title", JOptionPane.INFORMATION_MESSAGE);
    }

    public void update() {
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public boolean isHtmlTabSelected() {
        return tabbedPane.getSelectedIndex() == 0;
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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
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
