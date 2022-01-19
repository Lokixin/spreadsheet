package edu.upc.etsetb.arqsoft.usecases.externalfiles;

import edu.upc.etsetb.arqsoft.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.entities.cell.impl.Cell;
import edu.upc.etsetb.arqsoft.entities.cell.impl.Coordinate;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.Math.floor;
import static java.lang.Math.log;

public class SpreadsheetSaver {


    public String spreadsheetToSV2(Spreadsheet sheet) {
        // Okay it is not efficient, but we have 6 subjects and we both work part-time.
        String toFile = "";
        int maxCol = sheet.colToIndex(sheet.getMaxCol());
        for (int row = 1; row <= sheet.getMaxRow(); row++) {

            for (int col = 1; col <= maxCol; col++) {
                Coordinate location = new Coordinate(row, sheet.indexToCol(col));
                Cell cell = sheet.getCells().get(location);
                if (cell == null) {
                    toFile += ";";
                } else {
                    toFile += cell.getContent().getContent();
                    if (col != maxCol) {
                        toFile += ";";
                    }
                }
            }
            toFile += "\n";
        }
        return toFile;
    }


    public void saveSpreadsheet(Spreadsheet sheet, String path) {
        String toFile = this.spreadsheetToSV2(sheet);
        System.out.println(toFile);
        try{
            FileWriter writer = new FileWriter(path);
            writer.write(toFile);
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
        }
    }
}
