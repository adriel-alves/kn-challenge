package com.kn.challenge.utils;

import com.kn.challenge.exception.FileNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Component
public class FileHelper {

    @Value("${file.name}")
    private String fileName;

    public FileHelper() {
    }

    public File getFileFromResource() {

        ClassLoader classLoader = getClass().getClassLoader();

        File inputFile;
        try {
            inputFile = new File(Objects.requireNonNull(classLoader.getResource(fileName)).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        if (inputFile.isFile()) {
            return inputFile;
        } else {
            throw new FileNotFoundException(fileName);
        }
    }
}
