package com.javarush.task.task31.task3107;

/* 
Null Object Pattern
Почитай на вики про паттерн «Null Object«.
Используй Files, чтобы в конструкторе класса Solution правильно инициализировать
поле fileData объектом ConcreteFileData.
Если возникли какие-то проблемы со чтением файла по пути pathToFile,
                                                                                                                                то инициализируй поле объектом NullFileData.
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
    }

    public FileData getFileData() {
        return fileData;
    }
}
