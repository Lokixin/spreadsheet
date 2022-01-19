/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class FormulaException extends Exception {

    /**
     * Creates a new instance of <code>FormulaException</code> without detail
     * message.
     */
    public FormulaException() {
    }

    /**
     * Constructs an instance of <code>FormulaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FormulaException(String msg) {
        super(msg);
    }
}
