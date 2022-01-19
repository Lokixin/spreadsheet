/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class BadTokenException extends Exception {

    /**
     * Creates a new instance of <code>BadTokenException</code> without detail
     * message.
     */
    public BadTokenException() {
    }

    /**
     * Constructs an instance of <code>BadTokenException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BadTokenException(String msg) {
        super(msg);
    }
}
