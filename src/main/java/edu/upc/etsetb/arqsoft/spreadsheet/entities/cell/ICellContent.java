package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell;


import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.NoNumericValue;

/**
 * Interface encapsulating every possible type of cell content.
 * The cell content can be Numerical, Textual or a Formula.
 */
public interface ICellContent {

    public abstract String getContent();
    public abstract double getValue() throws NoNumericValue;
}
