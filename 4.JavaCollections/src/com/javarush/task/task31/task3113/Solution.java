package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String directory = reader.readLine();
        reader.close();
        final int[] countDirectory = {-1};
        final int[] countFiles = {0};
        final long[] countLength = {0};



        if (!Files.isDirectory(Paths.get(directory))) {
            System.out.println(directory + " - не папка");
        } else {
            Files.walkFileTree(Paths.get(directory), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    countDirectory[0]++;
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countFiles[0]++;
                    countLength[0] += Files.size(file);
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Всего папок - " + countDirectory[0]);
            System.out.println("Всего файлов - " + countFiles[0]);
            System.out.println("Общий размер - " + countLength[0]);
        }
    }
}
