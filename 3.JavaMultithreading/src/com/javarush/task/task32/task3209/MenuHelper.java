package com.javarush.task.task32.task3209;

/*Добавь класс MenuHelper. Это будет вспомогательный класс для инициализации и настройки
меню.
У меню будет следующая структура:
— Файл
— Новый
— Открыть
— Сохранить
— Сохранить как…
— Выход

— Редактировать
— Отменить
— Вернуть
— Вырезать
— Копировать
— Вставить

— Стиль
— Полужирный
— Подчеркнутый
— Курсив
— Подстрочный знак
— Надстрочный знак
— Зачеркнутый

— Выравнивание
— По левому краю
— По центру
— По правому краю

— Цвет
— Красный
— Оранжевый
— Желтый
— Зеленый
— Синий
— Голубой
— Пурпурный
— Черный

— Шрифт
— Шрифт
— SansSerif, Serif, Monospaced, Dialog, DialogInput,
— Размер шрифта
— 6, 8, 10, 12, 14, 16, 20, 24, 32, 36, 48, 72

— Помощь
— О программе

7.1. Реализуй в MenuHelper статический метод JMenuItem
addMenuItem(JMenu parent, String text, ActionListener actionListener),
где parent — меню в которое мы добавляем пункт, text — текст добавляемого пункта,
actionListener — слушатель действий добавляемого пункта меню. Он должен:

7.1.1. Создавать новый пункт меню JMenuItem, используя text.
7.1.2. Устанавливать этому пункту слушателя действий с помощью метода addActionListener().
7.1.3. Добавлять в parent созданный пункт меню.
7.1.4. Возвращать созданный пункт меню.
7.2. Реализуй статический метод JMenuItem addMenuItem(JMenu parent, Action action).
Этот метод аналогичен предыдущему, но в качестве параметра принимает действие action,
которое необходимо выполнить при выборе пункта меню.

Подсказка: при создании JMenuItem передай в конструктор action.
Разберись откуда возьмется имя пункта меню, если его не устанавливать дополнительно.

7.3. Реализуй статический метод JMenuItem addMenuItem(JMenu parent,
String text, Action action), который добавляет в parent новый пункт
меню с текстом text и действием action при выборе этого метода.
При реализации используй вызов метода из предыдущего пункта.

7.4. Добавь в MenuHelper заглушки для следующих статический методов:

7.4.1. void initHelpMenu(View view, JMenuBar menuBar) — инициализация меню помощи.
7.4.2. void initFontMenu(View view, JMenuBar menuBar) — инициализация меню выбора
шрифта.
7.4.3. void initColorMenu(View view, JMenuBar menuBar) — инициализация меню выбора цвета.
7.4.4. void initAlignMenu(View view, JMenuBar menuBar) — инициализация меню выравнивания.
7.4.5. void initStyleMenu(View view, JMenuBar menuBar) — инициализация меню выбора стиля текста.
7.4.6. void initEditMenu(View view, JMenuBar menuBar) — инициализация меню редактирования текста.
7.4.7. void initFileMenu(View view, JMenuBar menuBar) — инициализация меню Файл.
* */

/*
7.1. Реализуй в MenuHelper статический метод JMenuItem
addMenuItem(JMenu parent, String text, ActionListener actionListener),
где parent — меню в которое мы добавляем пункт, text — текст добавляемого пункта,
actionListener — слушатель действий добавляемого пункта меню. Он должен:

7.1.1. Создавать новый пункт меню JMenuItem, используя text.
7.1.2. Устанавливать этому пункту слушателя действий с помощью метода addActionListener().
7.1.3. Добавлять в parent созданный пункт меню.
7.1.4. Возвращать созданный пункт меню. +

7.2. Реализуй статический метод JMenuItem addMenuItem(JMenu parent, Action action).
Этот метод аналогичен предыдущему, но в качестве параметра принимает действие action,
которое необходимо выполнить при выборе пункта меню.

Подсказка: при создании JMenuItem передай в конструктор action.
Разберись откуда возьмется имя пункта меню, если его не устанавливать дополнительно.

7.3. Реализуй статический метод JMenuItem addMenuItem(JMenu parent,
String text, Action action), который добавляет в parent новый пункт
меню с текстом text и действием action при выборе этого метода.
При реализации используй вызов метода из предыдущего пункта.


* */

import javax.swing.*;
import java.awt.event.ActionListener;

public class MenuHelper {
    public static JMenuItem addMenuItem(JMenu parent, String text, ActionListener actionListener) {
        JMenuItem jMenuItem = new JMenuItem(text);
        jMenuItem.addActionListener(actionListener);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, Action action) {
        JMenuItem jMenuItem = new JMenuItem(action);
        parent.add(jMenuItem);
        return jMenuItem;
    }

    public static JMenuItem addMenuItem(JMenu parent, String text, Action action) {
        JMenuItem jMenuItem = addMenuItem(parent , action);
        jMenuItem.setText(text);
        return jMenuItem;
    }

    public static void initHelpMenu(View view, JMenuBar menuBar) {

    }

    public static void initFontMenu(View view, JMenuBar menuBar) {

    }

    public static void initColorMenu(View view, JMenuBar menuBar) {

    }

    public static void initAlignMenu(View view, JMenuBar menuBar) {

    }

    public static void initStyleMenu(View view, JMenuBar menuBar) {

    }

    public static void initEditMenu(View view, JMenuBar menuBar) {

    }

    public static void initFileMenu(View view, JMenuBar menuBar) {

    }
}

