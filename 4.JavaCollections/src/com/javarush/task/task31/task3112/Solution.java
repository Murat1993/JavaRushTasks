package com.javarush.task.task31.task3112;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://www.amigo.com/ship/secretPassword.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL website = new URL(urlString);
        String fileName = urlString.split("/")[urlString.split("/").length - 1];

        Path tmp = Files.createTempFile(fileName, "tmp");
        Files.copy(website.openStream(), tmp);
        Files.move(tmp, Paths.get(downloadDirectory + "/" + fileName));

        return Paths.get(downloadDirectory + "/" + fileName);
    }
}
