package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

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

    public double operate(double a, double b) throws InvalidOperator{
        //TO BE IMPLEMENTED
        switch (this.symbol){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "/":
                return a/b;
            case "*":
                return a*b;
            default:
                throw new InvalidOperator("Invalid operator found while operating");
        }
    }


    public void acceptVisitor(ComponentVisitor visitor){
        visitor.visitOperator(this);
    }
}

