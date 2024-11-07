package ru.top.academy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadAndWrite {
    static File file = new File("source.txt");
    static File newFile = new File("copy.txt");

    public FileReadAndWrite() {
        try (FileReader fileReader = new FileReader(file);
             FileWriter fileWriter = new FileWriter(newFile);) {

            if (!file.exists()) {
                createNewFile(file);
            }
            if (!newFile.exists()) {
                createNewFile(newFile);
            }
            writeInNewFile(fileReader, fileWriter);
        } catch (IOException e) {
        }
        createNewDirectory();
        moveFileInNewDirectory();
    }

    private void moveFileInNewDirectory() {
        Path copyFile = Paths.get("source.txt");
        Path destinationPath = Paths.get("newDir/source.txt");

        try {
            if (!Files.exists(destinationPath)) {
                Files.move(copyFile, destinationPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createNewDirectory() {
        File newDir = new File("newDir");
        if (!newDir.exists()) {
            newDir.mkdirs();
        }
    }

    private void writeInNewFile(FileReader fileReader, FileWriter fileWriter) throws IOException {
        int data;
        while ((data = fileReader.read()) != -1) {
            fileWriter.write(data);
        }
    }

    private static void createNewFile(File file) throws IOException {
        file.createNewFile();
    }
}
