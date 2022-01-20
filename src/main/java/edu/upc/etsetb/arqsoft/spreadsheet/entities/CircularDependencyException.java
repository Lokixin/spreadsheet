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
public class CircularDependencyException extends Exception {

    /**
     * Creates a new instance of <code>CircularDependencyException</code>
     * without detail message.
     */
    public CircularDependencyException() {
    }

    /**
     * Constructs an instance of <code>CircularDependencyException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public CircularDependencyException(String msg) {
        super(msg);
    }
}
