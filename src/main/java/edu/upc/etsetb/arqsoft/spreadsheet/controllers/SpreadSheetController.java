package edu.upc.etsetb.arqsoft.spreadsheet.controllers;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.CellFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.ContentFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IExpressionGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.Formula;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.BadTokenException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.ITokenizer;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.externalfiles.SpreadsheetSaver;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.parser.Tokenizer;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.PostfixEvaluator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SpreadSheetController {

    protected Spreadsheet spreadsheet;
    protected SpreadsheetSaver sheetSaver;
    protected CellFactory cellFactory;
    protected ContentFactory contentFactory;
    private HashMap<Coordinate, HashSet<Coordinate>> dependencies;

    public SpreadSheetController() {
        this.spreadsheet = null;
        this.sheetSaver = new SpreadsheetSaver();
        this.contentFactory = new ContentFactory();
        this.dependencies = new HashMap<>();
        this.cellFactory = new CellFactory();

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
        Coordinate location =  new Coordinate(coordinate);
        Cell cell = this.spreadsheet.getCells().get(location);
        ICellContent content = this.contentFactory.makeContent(newContent);
        String msg = "";
        // Check if content type is formula
        if (newContent.startsWith("=")){
            IExpressionGenerator gen = null;
            try{
                IFormulaExpressionFactory factory = IFormulaExpressionFactory.getInstance("DEFAULT");
                gen = factory.createExpressionGenerator("postfix",factory);
                PostfixEvaluator pe = new PostfixEvaluator(this.spreadsheet);
                gen.generateFromString(newContent.substring(1));

                double result = pe.evaluate(gen.getResult(), (Formula) content);
                displayPostfix(gen.getResult(), result);
                content.setValue(result);
                this.updateDependencies(coordinate, newContent.substring(1));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        if (cell == null){
            cell = this.cellFactory.makeCell(coordinate, content);
            this.spreadsheet.getCells().put(location, cell);
            this.spreadsheet.updateCorners(location);
            try {
                this.updateDependencies(coordinate, newContent.substring(1));
            } catch (BadTokenException e) {
                e.printStackTrace();
            }
        }else {
            this.spreadsheet.getCells().get(location).setContent(content);
        }
        //String msg = this.spreadsheet.editCell(coordinate, newContent);
        this.spreadsheet.displaySpreadsheet();
        this.updateSpreadsheet(coordinate);
        msg = "Cell edited at" + location.toString() + " .With content: " + cell.getContent().toString();
        return msg;
    }


    public String loadSheetFromFile(String pathToFile){
        return "";
    }

    public String saveSheet(String pathToFile){
        this.sheetSaver.saveSpreadsheet(this.spreadsheet, pathToFile);
        return "";
    }

    private void displayPostfix(List<IToken>tokens, Double result){
        StringBuilder postfixText = new StringBuilder();
        for (IToken c : tokens) {
            postfixText.append(c.getText()).append(" ");
        }
        System.out.println("[LOG]->Postfix expression: " + postfixText);
        System.out.println("[LOG]->Result from previous expression: "+result);
    }

    public void updateDependencies(String coordinate, String formulaExpression) throws BadTokenException{
        System.out.println("[LOG]-> Updating dependencies...");
        ITokenizer tokenizer = null;
        IFormulaExpressionFactory factory = null;
        try {
            factory = IFormulaExpressionFactory.getInstance("DEFAULT");
            tokenizer = factory.createTokenizer(factory);
            tokenizer.tokenize(formulaExpression);
            List<IToken> tokens = tokenizer.getResult();
            for(IToken token : tokens){
                if (token.isCell()){
                    Coordinate location = new Coordinate(coordinate);
                    Coordinate tokenLocation = new Coordinate(token.getText());
                    if(!this.dependencies.containsKey(tokenLocation)){
                        HashSet<Coordinate> listCells = new HashSet<>();
                        listCells.add(location);
                        dependencies.put(tokenLocation, listCells);
                    }else if (token.isCell()){
                        if (this.dependencies.containsKey(tokenLocation)){
                            HashSet<Coordinate>listCells = dependencies.get(tokenLocation);
                            if(!listCells.contains(location)){
                                listCells.add(location);
                                this.dependencies.put(tokenLocation, listCells);
                            }
                        }
                    }

                }
            }
        } catch (UnkownFactoryException ex) {
            System.out.println("An error has occurred while trying to "
                    + "create the tokenizer. Details: " + ex.getMessage());
            ex.printStackTrace();
            System.out.println("ENDING EXECUTION...");
            System.exit(-1);
        }

    }

    public void updateSpreadsheet(String coordinate) {
        System.out.println("[LOG]-> Updating Spreadsheet...");
        Coordinate location = new Coordinate(coordinate);
        if (this.dependencies.containsKey(location)) {
            HashSet<Coordinate> listCells = dependencies.get(location);
            for (Coordinate cellCoordinate: listCells){
                this.reCompute(cellCoordinate);
            }
        }
    }


    public void reCompute(Coordinate coordinate){
        System.out.println("[LOG]-> Recomputing...");
        String expression = this.spreadsheet.getCells().get(new Coordinate(coordinate.getRow(), coordinate.getColumn())).getContent().getContent();
        if (expression.startsWith("=")){
            System.out.println("Formula expression: " + expression);
            String loc = String.format("%s%d", coordinate.getColumn(), coordinate.getRow());
            this.editCell(loc, expression);
        }
    }

}
