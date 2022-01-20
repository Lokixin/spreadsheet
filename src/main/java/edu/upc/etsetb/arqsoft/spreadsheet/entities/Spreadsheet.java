package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.CellFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.ContentFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IExpressionGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostfixEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.log;

/**
 * Class representing a spreadsheet. Instances of this class would be displayed
 * by the UI. It contains a collection of cells.
 */
public class Spreadsheet {
    protected HashMap<Coordinate, Cell> cells;
    protected CellFactory cellFactory;
    protected ContentFactory contentFactory;

    protected String maxCol;
    protected int maxRow;

    public Spreadsheet() {
        this.cells = new HashMap<>();
        this.cellFactory = new CellFactory();
        this.contentFactory = new ContentFactory();
        this.maxCol = "A";
        this.maxRow = 1;
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

    /**
     * Checks and updates the max column and max row of the
     * spreadsheet if needed.
     * @param coordinate
     */
    public void updateCorners(Coordinate coordinate){
        if ( this.colToIndex(coordinate.getColumn()) > this.colToIndex(this.maxCol)) {
            this.maxCol = coordinate.getColumn();
            System.out.println(this.maxCol);
        }

        if (coordinate.getRow() > this.maxRow) {
            this.maxRow = coordinate.getRow();
            System.out.println(this.maxRow);
        }
    }

    public String getMaxCol() {
        return maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public HashMap<Coordinate, Cell> getCells() {
        return cells;
    }

    public void displaySpreadsheet(){
        for(int row=1; row <= this.maxRow; row++){
            System.out.println(String.join(" ", Collections.nCopies(this.colToIndex(this.maxCol), "----")));
            for (int col=1; col <= this.colToIndex(this.maxCol); col++){
                Cell cell = this.cells.get(new Coordinate(row, this.indexToCol(col)));
                if (cell == null){
                    System.out.print("| 0 |");
                }else {
                    System.out.print("| " + cell.getContent().getContent() + " ");
                }
            }
            System.out.println("");
        }
    }
}
