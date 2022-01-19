package edu.upc.etsetb.arqsoft.entities.cell.impl;

import edu.upc.etsetb.arqsoft.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.entities.cell.formula.impl.Formula;

public class CellFactory {

    protected ContentFactory contentFactory;

    public CellFactory(){
        this.contentFactory = new ContentFactory();
    }

    public Cell makeCell(String cord, String content){

        ICellContent cellContent = this.contentFactory.makeContent(content);
        Coordinate coordinate = new Coordinate(cord);
        Cell cell = new Cell(coordinate, cellContent);
        return cell;
    }
}











