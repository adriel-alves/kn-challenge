package com.kn.challenge.exception;

public final class ImportFileException extends RuntimeException{
    public ImportFileException(){
        super("an Error occurred when trying to import file.");
    }
}
