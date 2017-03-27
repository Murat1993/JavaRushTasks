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
Реализуй метод selectedTabChanged() представления. Этот метод вызывается,
 когда произошла смена выбранной вкладки. Итак:

18.1. Метод должен проверить, какая вкладка сейчас оказалась выбранной.

18.2. Если выбрана вкладка с индексом 0 (html вкладка),
значит нам нужно получить текст из plainTextPane и установить его в контроллер
с помощью метода setPlainText.

18.3. Если выбрана вкладка с индексом 1 (вкладка с html текстом),
то необходимо получить текст у контроллера с помощью метода getPlainText()
и установить его в панель plainTextPane.

18.4. Сбросить правки (вызвать метод resetUndo представления).

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
