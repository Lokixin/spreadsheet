package edu.upc.etsetb.arqsoft.entities.cell.impl;

import edu.upc.etsetb.arqsoft.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.entities.cell.formula.IOperand;

/**
 * Concrete class representing a cell inside a spreadsheet.
 * A cell is mainly defined by its coordinate (row, column)
 * and its content.
 */

public class Cell implements IOperand {

    protected Coordinate coordinate;
    protected ICellContent content;

    public Cell(Coordinate coordinate, ICellContent content) {
        this.coordinate = coordinate;
        this.content = content;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ICellContent getContent() {
        return content;
    }

    public void setContent(ICellContent content) {
        this.content = content;
    }
}
