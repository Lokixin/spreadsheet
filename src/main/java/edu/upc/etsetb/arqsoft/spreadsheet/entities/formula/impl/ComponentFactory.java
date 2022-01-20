package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.MaxFunction;

public class ComponentFactory {

    public ComponentFactory(){}

    public IFormulaContent makeComponent(IToken token){
        switch (token.getType()){
            case OPERATOR:
                return new Operator(token.getText());
            case NUM:
                return new Numerical(token.getText());
            case CELL:
                return new Coordinate(token.getText());
            case FUNCTION:
                return new MaxFunction();
            default:
                return null;
        }
    }
}
