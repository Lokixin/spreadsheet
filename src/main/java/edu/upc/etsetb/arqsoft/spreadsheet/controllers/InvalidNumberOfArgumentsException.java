package edu.upc.etsetb.arqsoft.spreadsheet.controllers;

public class InvalidNumberOfArgumentsException extends RuntimeException{

    public InvalidNumberOfArgumentsException() {}

    public InvalidNumberOfArgumentsException(String message) {
        super(message);
    }
}
