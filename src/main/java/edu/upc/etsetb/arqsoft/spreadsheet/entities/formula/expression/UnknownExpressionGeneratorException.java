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
public class UnknownExpressionGeneratorException extends Exception {

    /**
     * Creates a new instance of
     * <code>UnknownExpressionGeneratorException</code> without detail message.
     */
    public UnknownExpressionGeneratorException() {
    }

    /**
     * Constructs an instance of
     * <code>UnknownExpressionGeneratorException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public UnknownExpressionGeneratorException(String msg) {
        super(msg);
    }
}
