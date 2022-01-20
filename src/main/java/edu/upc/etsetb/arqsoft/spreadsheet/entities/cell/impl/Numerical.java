package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

/**
 * Numerical class represents the content of cells containing
 * numerical values.
 */

public class Numerical implements ICellContent, IOperand {

    protected String content;
    protected double value;

    public Numerical(String content) {
        this.content = content;
        this.value = Double.parseDouble(content);
    }

    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }


    public String getContent() {
        return content;
    }



    @Override
    public String toString() {
        return "Numerical{" +
                "value=" + value +
                '}';
    }

    @Override
    public void acceptVisitor(ComponentVisitor visitor) {
        visitor.visitANumber(this);
    }
}
