package edu.upc.etsetb.arqsoft.controllers;

public class InvalidCommandException extends RuntimeException{
    public InvalidCommandException() {}

    public InvalidCommandException(String message) {
        super(message);
    }
}
