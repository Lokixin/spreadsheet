package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;

/**
 * Textual class represents the content of the cells containing
 * strings.
 */

public class Textual implements ICellContent {

    protected String content;
    protected String value;

    public Textual(String content) {
        this.content = content;
        this.value = content;
    }

    public double getValue() throws NoNumericValue{
        throw new NoNumericValue("You're trying to opperate with a textual cell");
    }

    public void setValue(String value) {
        this.value = value;
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