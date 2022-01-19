package edu.upc.etsetb.arqsoft.entities.cell;


/**
 * Interface encapsulating every possible type of cell content.
 * The cell content can be Numerical, Textual or a Formula.
 */
public interface ICellContent {

    public abstract String getContent();
}
