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
public class UnkonwnExpressionTypeException extends Exception {

    /**
     * Creates a new instance of <code>UnkonwnExpressionTypeException</code>
     * without detail message.
     */
    public UnkonwnExpressionTypeException() {
    }

    /**
     * Constructs an instance of <code>UnkonwnExpressionTypeException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UnkonwnExpressionTypeException(String msg) {
        super(msg);
    }
}
