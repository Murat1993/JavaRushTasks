package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        String[] split = resultFileAbsolutePath.split("/");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length - 1; i++) {
            builder.append(split[i]).append("/");
        }
        builder.append("allFilesContent.txt");

        Map<String, File> files = new TreeMap<>();

        try {
            Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toFile().length() > 50 && file.toFile().isFile()) {
                        FileUtils.deleteFile(file.toFile());
                    }

                    if (file.toFile().length() <= 50) {
                        files.put(file.getFileName().toString(), file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

            File resultFile = new File(resultFileAbsolutePath);
            File file = new File(builder.toString());
            FileUtils.renameFile(resultFile, file);

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, File> pair : files.entrySet()) {
                BufferedReader reader = new BufferedReader(new FileReader(pair.getValue()));
                String string;
                while ((string = reader.readLine()) != null) {
                    writer.write(string);
                }
                writer.write(System.lineSeparator());
            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
