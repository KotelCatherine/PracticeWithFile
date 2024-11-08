package ru.top.academy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadAndWrite {
    static File file = new File("source.txt");
    static File newFile = new File("copy.txt");

    public FileReadAndWrite() {
        try (FileReader fileReader = new FileReader(file);
             FileWriter fileWriter = new FileWriter(newFile);) {

            isFileExistsMethod(file);
            isFileExistsMethod(newFile);
            writeInNewFile(fileReader, fileWriter);
            createNewDirectory();
            moveFileInNewDirectory();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            throw new RuntimeException();
        }
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

    private void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void isFileExistsMethod(File file) {
        if (!file.exists()) {
            createNewFile(file);
        }
    }
}



