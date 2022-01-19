package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl;

import java.util.Objects;

/**
 * The Coordinate class represents the location of a cell within the spreadsheet.
 * A coordinate is defined by its row and column.
 * Rows are integers following the natural order.
 * Columns are Strings following the alphabetical order.
 */

public class Coordinate {

    protected int row;
    protected String column;

    public Coordinate(String coordinate){
        this.parseCoordinateString(coordinate);
    }

    public Coordinate(int row, String column) {
        this.row = row;
        this.column = column;
    }

    private void parseCoordinateString(String coordinate) {
        String[] colRow = coordinate.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        this.column = colRow[0].toUpperCase();
        this.row = Integer.parseInt(colRow[1]);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column.equals(that.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "row=" + row +
                ", column='" + column + '\'' +
                '}';
    }
}
