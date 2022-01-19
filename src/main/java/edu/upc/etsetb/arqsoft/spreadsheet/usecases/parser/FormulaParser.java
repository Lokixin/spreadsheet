package edu.upc.etsetb.arqsoft.spreadsheet.usecases.parser;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;

import java.util.ArrayList;

/**
 * The FormulaParser class returns a set of operators and operands from the input string given by the user.
 */
public class FormulaParser {

    public FormulaParser(String inputFormula) {
        this.inputFormula = inputFormula;
    }

    protected String inputFormula;

    public ArrayList<IFormulaContent> parseFormula(){
        return null;
    }


}
