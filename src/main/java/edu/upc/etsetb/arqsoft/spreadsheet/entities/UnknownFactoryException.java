/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities;

/**
 *
 * @author JuanCarlos
 */
public class UnknownFactoryException extends Exception {

    /**
     * Creates a new instance of <code>UnkownFactoryException</code> without
     * detail message.
     */
    public UnknownFactoryException() {
    }

    /**
     * Constructs an instance of <code>UnkownFactoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnknownFactoryException(String msg) {
        super(msg);
    }
}
