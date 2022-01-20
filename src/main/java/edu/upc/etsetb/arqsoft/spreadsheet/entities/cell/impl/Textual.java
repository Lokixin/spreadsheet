package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;

/**
 * Textual class represents the content of the cells containing
 * strings.
 */

public class Textual implements ICellContent {

    protected String content;
    protected Double value;

    public Textual(String content) {
        this.content = content;
        this.value = 0.0;
    }

    public double getValue() throws NoNumericValue{
        throw new NoNumericValue("You're trying to opperate with a textual cell");
    }

    @Override
    public void setValue(double value) {
        throw new UnsupportedOperationException("Can't assign value to textual cell");
    }


    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Textual{" +
                "value='" + value + '\'' +
                '}';
    }
}