package com.kn.challenge.exception;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String filePath) {
        super(String.format("File not found! %s",filePath));
    }
}
