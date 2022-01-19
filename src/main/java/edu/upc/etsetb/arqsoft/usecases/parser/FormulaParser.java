package edu.upc.etsetb.arqsoft.usecases.parser;

import edu.upc.etsetb.arqsoft.entities.cell.formula.IFormulaContent;

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
