package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.parser.FormulaParser;

import java.util.ArrayList;

/**
 * Given the set of tokes generates the postfix expression.
 */
public class PostfixExpressionGenerator {

    protected FormulaParser formulaParser;
    protected ArrayList<IFormulaContent> tokens;

    public PostfixExpressionGenerator(ArrayList<IFormulaContent> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<IFormulaContent> generatePostfix() {
        return  null;
    }
}
