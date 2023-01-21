package com.kn.challenge.utils;

import com.kn.challenge.exception.FileNotFoundException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileHelper {
    // private final String filePath = "/Users/adrielalves/workspace/challenge/challenge/src/main/resources/people.csv";

    public FileHelper() {
        //this.filePath = filePath;
    }

    public File getFileFromResource() {

        Path path = Paths.get("/Users/adrielalves/workspace/challenge/challenge/src/main/resources/people.csv");
        File inputFile = new File(path.toUri());

        if (inputFile.isFile()) {
            return inputFile;
        } else {
            throw new FileNotFoundException("/Users/adrielalves/workspace/challenge/challenge/src/main/resources/people.csv");
        }

    }
}
