package edu.upc.etsetb.arqsoft.entities.cell.formula.impl;

import edu.upc.etsetb.arqsoft.entities.cell.formula.IFormulaContent;

/**
 * Operator class represents the possible operators
 * that can be present in a formula: +, -, *, /.
 */
public class Operator implements IFormulaContent {
    protected String symbol;

    public Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
