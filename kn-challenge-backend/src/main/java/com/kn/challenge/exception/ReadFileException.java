package com.kn.challenge.exception;

public final class ReadFileException extends RuntimeException {
    public ReadFileException(String filePath) {
        super(String.format("An error occurred while trying to read %s ", filePath));
    }
}
