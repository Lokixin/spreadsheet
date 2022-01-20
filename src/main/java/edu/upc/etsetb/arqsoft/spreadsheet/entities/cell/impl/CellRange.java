package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

import java.util.HashMap;
import java.util.HashSet;

import static java.lang.Math.floor;
import static java.lang.Math.log;

/**
 * Represents a contiguous set of cells present in the spreadsheet.
 */
public class CellRange implements IArgument, IFormulaContent {

    protected String range;
    protected HashSet<Coordinate> coordinates;
    protected Coordinate initialCoordinate;
    protected Coordinate finalCoordinate;


    public CellRange(String range) {
        this.range = range;
        this.splitCoordinates();
        this.coordinates = this.generateRange();
    }

    public void splitCoordinates(){
        String[] coordinates = this.range.split(":");
        this.initialCoordinate = new Coordinate(coordinates[0]);
        this.finalCoordinate = new Coordinate(coordinates[1]);
    }

    public HashSet<Coordinate> generateRange(){
        HashSet<Coordinate>coordinates = new HashSet<>();
        int maxRow = this.finalCoordinate.getRow();
        int maxCol = this.colToIndex(this.finalCoordinate.getColumn());

        int minRow = this.initialCoordinate.getRow();
        int minCol = this.colToIndex(this.initialCoordinate.getColumn());

        for (int row = minRow; row <= maxRow; row ++){
            for (int col = minCol; col <= maxCol; col++){
                Coordinate auxCoordinate = new Coordinate(row, this.indexToCol(col));
                coordinates.add(auxCoordinate);
            }
        }
        return coordinates;
    }

    /**
     * Transforms the column label to a numerical index. For example A -> 1, Z -> 26, AB -> 28
     * @param column
     * @return
     */
    public int colToIndex(String column){
        int alphabetLength = 26;
        char[] colArray = column.toCharArray();
        int acc = 0;
        for (int i=0; i < colArray.length; i++)  {
            int weight = (int) Math.pow(alphabetLength, i);
            int mod = ((int)colArray[colArray.length - i - 1] - (int)'A'+1) % alphabetLength;
            acc += weight * (mod);
        }
        return acc;
    }

    /**
     * Transforms the given index to a column label string.
     * It is the inverse operation of colToIndex function.
     * @param index
     * @return
     */
    public String indexToCol(int index) {
        char[] buf = new char[(int) floor(log(25 * (index + 1)) / log(26))];
        for (int i = buf.length - 1; i >= 0; i--) {

            index--;
            buf[i] = (char) ('A' + index % 26);
            index /= 26;
        }
        return new String(buf);
    }

    @Override
    public void acceptVisitor(ComponentVisitor visitor) {
        for(Coordinate c: this.coordinates){
            c.acceptVisitor(visitor);
        }
    }
}
