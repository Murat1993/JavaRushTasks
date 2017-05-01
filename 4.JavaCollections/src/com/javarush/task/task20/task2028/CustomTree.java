package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

/* 
Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
1.  В классе CustomTree создай вложенный статический параметризированный
класс Entry<T> с модификатором доступа по умолчанию. +

2. Обеспечь поддержку этим классом интерфейса Serializable. +

3. Создай такие поля (модификатор доступа по умолчанию):
— String elementName;
— int lineNumber;
— boolean availableToAddLeftChildren, availableToAddRightChildren;
— Entry<T> parent, leftChild, rightChild; +

4. Реализуй публичный конструктор с одним параметром типа String:
— установи поле elementName равным полученному параметру;
— установи поле availableToAddLeftChildren равным true;
— установи поле availableToAddRightChildren равным true; +

5. Реализуй метод void checkChildren, устанавливающий поле availableToAddLeftChildren в false,
 если leftChild не равен null и availableToAddRightChildren в false,
  если rightChild не равен null. +

6. Реализуй метод boolean isAvailableToAddChildren,
возвращающий дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.

Любое дерево начинается с корня,
 поэтому не забудь в класс CustomTree добавить поле root типа Entry<String> c модификатором доступа по умолчанию.


*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String name) {
            this.elementName = name;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        void checkChildren() {
            if (this.leftChild != null) {
                availableToAddLeftChildren = false;
            }

            if (this.rightChild != null) {
                availableToAddRightChildren = false;
            }
        }

    }


    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return 0;
    }
}
