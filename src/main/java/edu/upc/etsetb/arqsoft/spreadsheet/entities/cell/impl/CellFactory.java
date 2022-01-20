package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;

public class CellFactory {

    protected ContentFactory contentFactory;

    public CellFactory(){
        this.contentFactory = new ContentFactory();
    }

    public Cell makeCell(String cord, ICellContent content){

        ICellContent cellContent = content;
        Coordinate coordinate = new Coordinate(cord);
        Cell cell = new Cell(coordinate, cellContent);
        return cell;
    }
}











