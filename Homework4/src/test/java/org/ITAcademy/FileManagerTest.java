package org.ITAcademy;


import org.ITAcademy.Models.Person;
import org.ITAcademy.Utilities.FileManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagerTest {

    private static final String OBJECTS_FILE_PATH = "src/test/resources/objects.txt";
    private static final String FILE_PATH = "src/test/resources/test.txt";
    private static final Person PERSON_1 = new Person("Артем", "Юшкевич", 20);
    private static final Person PERSON_2 = new Person("Артем", "Костевич", 22);


    @BeforeAll
    public static void createFiles() throws IOException {
        assertTrue(new File(OBJECTS_FILE_PATH).createNewFile());
        assertTrue(new File(FILE_PATH).createNewFile());
    }

    @BeforeAll
    public static void writeObjects(){

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(OBJECTS_FILE_PATH)))) {
            oos.writeObject(PERSON_1);
            oos.writeObject(PERSON_2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileManagerTest(){

        List<Person> expected = new ArrayList<>(List.of(PERSON_1, PERSON_2));
        FileManager.writeObjects(expected, FILE_PATH);

        boolean isFilesTheSame = compareFiles(OBJECTS_FILE_PATH, FILE_PATH);

        List<Person> actual = FileManager.readObjects(FILE_PATH).stream().map(p -> (Person) p).collect(Collectors.toList());
        assertTrue(new File(FILE_PATH).exists());
        assertTrue(isFilesTheSame);
        assertEquals(expected, actual);
    }

    private boolean compareFiles(String path1, String path2) {
        try (BufferedInputStream fis1 = new BufferedInputStream(Files.newInputStream(Paths.get(path1)));
             BufferedInputStream fis2 = new BufferedInputStream(Files.newInputStream(Paths.get(path2)))) {
            int currentByte;
            while ((currentByte = fis1.read()) != -1) {
                if (currentByte != fis2.read()) {
                    return false;
                }
            }
            return fis2.read() == -1;
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @AfterAll
    public static void deleteFiles() {
        assertTrue(new File(OBJECTS_FILE_PATH).delete());
        assertTrue(new File(FILE_PATH).delete());
    }
}