package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import java.util.ArrayList;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.NoNumericValue;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IExpressionGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;

/**
 * The Formula class contains all the operands and operators
 * provided by the user. Also, the value resulting of the formula
 * computation.
 */
public class Formula implements ICellContent {
    protected String content;
    protected double value;
    protected ArrayList<IToken> formulaContent;

    public Formula(String content){
        this.content = content;
        this.formulaContent = new ArrayList<>();
    }


    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    public String getContent() {
        return content;
    }



    @Override
    public double getValue() throws NoNumericValue {
        return this.value;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "content='" + content + '\'' +
                ", value=" + value +
                '}';
    }


}
