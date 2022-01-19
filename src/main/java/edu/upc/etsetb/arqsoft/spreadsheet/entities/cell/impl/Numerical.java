package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;

/**
 * Numerical class represents the content of cells containing
 * numerical values.
 */

public class Numerical implements ICellContent, IOperand {

    protected String content;
    protected float value;

    public Numerical(String content) {
        this.content = content;
        this.value = Float.parseFloat(content);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
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
}
