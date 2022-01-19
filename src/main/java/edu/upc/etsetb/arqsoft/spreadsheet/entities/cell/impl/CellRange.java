package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;

import java.util.HashMap;

/**
 * Represents a contiguous set of cells present in the spreadsheet.
 */
public class CellRange implements IArgument {

    protected HashMap<Coordinate, Cell> cells;

    public CellRange(HashMap<Coordinate, Cell> cells) {
        this.cells = cells;
    }

}
