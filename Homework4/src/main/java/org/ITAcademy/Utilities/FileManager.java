package org.ITAcademy.Utilities;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static <T extends Serializable> void writeObjects(List<T> objects, String outFilePath) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(outFilePath)))) {
            objects.forEach(o -> {
                try {
                    outputStream.writeObject(o);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<Object> readObjects(String inFilePath) {
        List<Object> result = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(inFilePath)))) {
            while (true) {
                try {
                    result.add(inputStream.readObject());
                } catch (ClassNotFoundException | EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}