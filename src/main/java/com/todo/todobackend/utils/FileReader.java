package com.todo.todobackend.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileReader {

    final static String DIRECTORY = ".";

    public static String getMetaFile() throws IOException {
        File folder = new File(DIRECTORY);
        Optional<File[]> files = Optional.ofNullable(folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().equalsIgnoreCase("meta.txt") && !file.isHidden();
            }
        }));

        if (files.isPresent()) {
            return FileReader.readFile(files.get()[0], Charset.defaultCharset());
        }

        return "";
    }

    /**
     * Lists .js files in specific folder
     *
     * @return array of files
     */
    static File[] listFiles() {
        File folder = new File(DIRECTORY);
        File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isFile() && file.getName().toLowerCase().endsWith(".js") && !file.isHidden();
            }
        });

        return files;
    }

    /**
     * Reads the content of a file
     * @return string
     */
    public static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(file.getPath()));
        return new String(encoded, encoding);
    }

    /**
     * Writes content into file
     *
     * @return boolean
     */
    static boolean writeFile(String input, Path path, Charset encoding) {
        try (BufferedWriter writer = Files.newBufferedWriter(path, encoding)) {
            writer.write(input, 0, input.length());
            return true;
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return false;
    }
}
