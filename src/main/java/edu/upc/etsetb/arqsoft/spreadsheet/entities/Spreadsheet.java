package edu.upc.etsetb.arqsoft.spreadsheet.entities;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.CellFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.ContentFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;

import java.util.HashMap;

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
     * Create and add a new cell if the given coordinate does not exist.
     * Update the cell content of an existing cell if the given coordinate exists.
     * @param coordinate
     * @param content
     * @return
     */

    public String editCell(String coordinate, String content){

        Coordinate location = new Coordinate(coordinate);
        Cell cell = this.cells.get(location);

        if (cell == null){
            cell = this.cellFactory.makeCell(coordinate, content);
            cells.put(cell.getCoordinate(), cell);

            // Update max row and column if necessary
            if ( this.colToIndex(location.getColumn()) > this.colToIndex(this.maxCol)) {
                this.maxCol = location.getColumn();
                System.out.println(this.maxCol);
            }

            if (location.getRow() > this.maxRow) {
                this.maxRow = location.getRow();
                System.out.println(this.maxRow);
            }

        }else {
            cell.setContent(this.contentFactory.makeContent(content));
        }

        return "Cell successfully edited at "+cell.getCoordinate().toString()+" :\n" + cell.getContent().toString();
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

    public String getMaxCol() {
        return maxCol;
    }

    public int getMaxRow() {
        return maxRow;
    }

    public HashMap<Coordinate, Cell> getCells() {
        return cells;
    }
}
