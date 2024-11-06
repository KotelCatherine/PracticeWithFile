package ru.top.academy;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1. Создание файла:
 * Создайте файл с именем source.txt в текущей директории.
 * Запишите в этот файл некий текст
 * 2. Копирование содержимого:
 * Прочитайте содержимое файла source.txt.
 * Создайте новый файл с именем copy.txt в той же директории.
 * Скопируйте содержимое из source.txt в copy.txt.
 * 3. Перемещение файла:
 * Создайте директорию с именем newDir в текущей директории.
 * Переместите файл source.txt в директорию newDir.
 * 4. Проверка перемещения и копирования:
 * После выполнения всех операций проверьте, что:
 * Файл source.txt находится в newDir.
 * Файл copy.txt содержит текст из source.txt.
 */
public class Main {

    public static void main(String[] args) {
        new FileReadAndWrite();
    }

}