package edu.upc.etsetb.arqsoft.spreadsheet.controllers;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.externalfiles.SpreadsheetSaver;

public class SpreadSheetController {

    protected Spreadsheet spreadsheet;
    protected SpreadsheetSaver sheetSaver;

    public SpreadSheetController() {
        this.spreadsheet = null;
        this.sheetSaver = new SpreadsheetSaver();
    }

    public String controlCommand(String[] cmd) throws InvalidCommandException{
        String msg;
        switch (cmd[0]){
            case "RF":
                msg = this.readCmdFile(cmd[1]);
                break;
            case "C":
                msg = this.createSpreadsheet();
                break;
            case "E":
                msg = this.editCell(cmd[1], cmd[2]);
                break;
            case "L":
                msg = this.loadSheetFromFile(cmd[1]);
                break;
            case "S":
                msg = this.saveSheet(cmd[1]);
                break;
            default:
                throw new InvalidCommandException("Command Not found");
        }
        return msg;
    }

    public String readCmdFile(String pathToFile) {
        return "";
    }

    public String createSpreadsheet(){
        this.spreadsheet = new Spreadsheet();
        return "Empty spreadsheet created";
    }

    public String editCell(String coordinate, String newContent){
        if (this.spreadsheet == null){
            throw new NoSpreadsheetException("No spreadsheet created yet");
        }
        String msg = this.spreadsheet.editCell(coordinate, newContent);
        return msg;
    }

    public String loadSheetFromFile(String pathToFile){
        return "";
    }

    public String saveSheet(String pathToFile){
        this.sheetSaver.saveSpreadsheet(this.spreadsheet, pathToFile);
        return "";
    }

}
