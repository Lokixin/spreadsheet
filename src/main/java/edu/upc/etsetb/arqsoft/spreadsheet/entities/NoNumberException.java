/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class NoNumberException extends ContentException {

    /**
     * Creates a new instance of <code>NoNumberException</code> without detail
     * message.
     */
    public NoNumberException() {
    }

    /**
     * Constructs an instance of <code>NoNumberException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NoNumberException(String msg) {
        super(msg);
    }
}
