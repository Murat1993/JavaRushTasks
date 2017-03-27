package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/*
23.1. Напишем метод для сохранения открытого файла saveDocument().
Метод должен работать также, как saveDocumentAs(), но не запрашивать файл у пользователя,
а использовать currentFile. Если currentFile равен null, то вызывать метод saveDocumentAs().

23.2. Пришло время реализовать метод openDocument().
Метод должен работать аналогично методу saveDocumentAs(), в той части,
которая отвечает за выбор файла.

Подсказка: Обрати внимание на имя метода для показа диалогового окна.

Когда файл выбран, необходимо:
23.2.1. Установить новое значение currentFile.
23.2.2. Сбросить документ.
23.2.3. Установить имя файла в заголовок у представления.
23.2.4. Создать FileReader, используя currentFile.
23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
23.2.6. Сбросить правки (вызвать метод resetUndo представления).
23.2.7. Если возникнут исключения — залогируй их и не пробрасывай наружу.
Проверь работу пунктов меню Сохранить и Открыть.
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

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        if (chooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());

            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }


    }

    public void saveDocument() {
        view.selectHtmlTab();
        if (currentFile != null) {
            try {
                new HTMLEditorKit().write(new FileWriter(currentFile), document, 0, document.getLength());
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }
        } else {
            saveDocumentAs();
        }
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

    /*23.2. Пришло время реализовать метод openDocument().
Метод должен работать аналогично методу saveDocumentAs(), в той части,
которая отвечает за выбор файла.

Подсказка: Обрати внимание на имя метода для показа диалогового окна.

Когда файл выбран, необходимо:
23.2.1. Установить новое значение currentFile.
23.2.2. Сбросить документ.
23.2.3. Установить имя файла в заголовок у представления.
23.2.4. Создать FileReader, используя currentFile.
23.2.5. Вычитать данные из FileReader-а в документ document с помощью объекта класса HTMLEditorKit.
23.2.6. Сбросить правки (вызвать метод resetUndo представления).
23.2.7. Если возникнут исключения — залогируй их и не пробрасывай наружу.
Проверь работу пунктов меню Сохранить и Открыть.
    * */

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        if (chooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader reader = new FileReader(currentFile);
                new HTMLEditorKit().read(reader, document, 0);
                view.resetUndo();
            } catch (FileNotFoundException e) {
                ExceptionHandler.log(e);
            } catch (IOException e) {
                ExceptionHandler.log(e);
            } catch (BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }

    }
}
