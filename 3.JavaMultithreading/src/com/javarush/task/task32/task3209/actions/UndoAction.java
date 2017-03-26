package com.javarush.task.task32.task3209.actions;

/*8.1. Напиши в пакете actions заглушки для следующих классов:

8.1.1. Класс отмены действия UndoAction.
Он должен наследоваться от AbstractAction и содержать конструктор UndoAction(View view). +

8.1.2. Класс возврата действия RedoAction. Требования аналогичны требованиям к UndoAction. +

8.1.3. Класс StrikeThroughAction, который отвечает за стиль текста «Зачеркнутый«.
Унаследуй его от StyledEditorKit.StyledTextAction. +

8.1.4. Класс SubscriptAction, который отвечает за стиль текста «Подстрочный знак«.
Его также унаследуй его от StyledEditorKit.StyledTextAction. +

8.1.5. Класс SuperscriptAction. Он будет отвечать за стиль «Надстрочный знак«.
Добавь ему правильный родительский класс. +
* */

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UndoAction extends AbstractAction {
    private View view;

    public UndoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        view.undo();
    }
}
