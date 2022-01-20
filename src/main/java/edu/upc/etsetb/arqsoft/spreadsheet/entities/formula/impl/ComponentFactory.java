package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.ClosingBrackent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.OpenBracket;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.FunctionFactory;


public class ComponentFactory {

    FunctionFactory functionFactory;
    public ComponentFactory(){
        this.functionFactory = new FunctionFactory();
    }

    public IFormulaContent makeComponent(IToken token){
        switch (token.getType()){
            case OPERATOR:
                return new Operator(token.getText());
            case NUM:
                return new Numerical(token.getText());
            case CELL:
                return new Coordinate(token.getText());
            case OPENINGB:
                return new OpenBracket();
            case CLOSINGB:
                return new ClosingBrackent();
            case FUNCTION:
                return functionFactory.makeFunction(token.getText());
            default:
                return null;
        }
    }
}
