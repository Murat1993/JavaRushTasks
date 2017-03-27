package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*20.1. Реализуй метод создания нового документа createNewDocument() в контроллере.
Он должен:


20.1.1. Выбирать html вкладку у представления.

20.1.2. Сбрасывать текущий документ. +

20.1.3. Устанавливать новый заголовок окна, например: «HTML редактор«.
 Воспользуйся методом setTitle(), который унаследован в нашем представлении.

20.1.4. Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.

20.1.5. Обнулить переменную currentFile.

20.2. Реализуй метод инициализации init() контроллера.
Он должен просто вызывать метод создания нового документа.

Проверь работу пункта меню Новый.
* */

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        try {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetDocument() {
        UndoListener listener = view.getUndoListener();
        if (document != null) {
            document.removeUndoableEditListener(listener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(listener);
        view.update();

    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {

    }

    public void saveDocument() {
    }

    public void saveDocumentAs() {
    }
}
