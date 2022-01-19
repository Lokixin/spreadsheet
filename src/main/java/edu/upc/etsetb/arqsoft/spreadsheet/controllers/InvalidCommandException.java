package edu.upc.etsetb.arqsoft.spreadsheet.controllers;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException() {}

    public InvalidCommandException(String message) {
        super(message);
    }
}
