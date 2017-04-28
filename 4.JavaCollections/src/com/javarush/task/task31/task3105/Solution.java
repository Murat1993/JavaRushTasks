package com.javarush.task.task31.task3105;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент — полный путь к файлу fileName.
Второй аргумент — путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию ‘new‘.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.

Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main).
 Нужно вычитать из него все содержимое. +

2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).

3. В ZipOutputStream нужно записать содержимое файла,
который приходит первым аргументом в main.

4. В ZipOutputStream нужно записать все остальное содержимое,
 которое было вычитано из ZipInputStream.

5. Потоки для работы с архивом должны быть закрыты.

*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String absolutePath = args[0];
        String zipFilePath = args[1];
        String[] splitPath = absolutePath.split("/");
        String fileName = splitPath[splitPath.length - 1];

        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
        BufferedInputStream bis = new BufferedInputStream(zis);
        Map<String, ArrayList<Byte>> filesInZip = new HashMap<>();

        ZipEntry zipEntry;
        while ((zipEntry = zis.getNextEntry()) != null) {
            if (zipEntry.getName().equals("new")) {
                continue;
            }
            int x;
            ArrayList<Byte> bytes = new ArrayList<>();
            while ((x = bis.read()) != -1) {
                bytes.add((byte) x);
            }
            filesInZip.put(zipEntry.toString(), bytes);
        }
        bis.close();
        zis.close();



        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath));
        BufferedOutputStream ous = new BufferedOutputStream(zos);
        zos.putNextEntry(new ZipEntry("new/" + fileName));
        BufferedReader reader = new BufferedReader(new FileReader(absolutePath));

        String string;
        while ((string = reader.readLine()) != null) {
            ous.write(string.getBytes());
            ous.write(System.lineSeparator().getBytes());
            ous.flush();
        }
        reader.close();

        for (Map.Entry<String, ArrayList<Byte>> pair : filesInZip.entrySet()) {
            zos.putNextEntry(new ZipEntry(pair.getKey()));
            for (byte b : pair.getValue()) {
                ous.write(b);
                ous.flush();
            }
        }
        ous.close();
        zos.close();

    }
}
