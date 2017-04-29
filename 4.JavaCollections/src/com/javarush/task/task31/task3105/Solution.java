package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;



public class Solution {
    public static void main(String[] args) throws IOException {
        String absoluteFilePath = args[0];
        String zipFilePath = args[1];
        String[] splitPath = absoluteFilePath.split("/");
        String fileName = splitPath[splitPath.length - 1];

        Map<String, ArrayList<Byte>> filesInZip = new HashMap<>();

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                int x;
                ArrayList<Byte> bytes = new ArrayList<>();
                while ((x = zis.read()) != -1) {
                    bytes.add((byte) x);
                }
                filesInZip.put(zipEntry.toString(), bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath))) {

            zos.putNextEntry(new ZipEntry("new/" + fileName));
            Files.copy(Paths.get(absoluteFilePath), zos);

            for (Map.Entry<String, ArrayList<Byte>> pair : filesInZip.entrySet()) {
                if (pair.getKey().equals("new/" + fileName)) {
                    continue;
                }
                zos.putNextEntry(new ZipEntry(pair.getKey()));
                for (byte b : pair.getValue()) {
                    zos.write(b);
                    zos.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
