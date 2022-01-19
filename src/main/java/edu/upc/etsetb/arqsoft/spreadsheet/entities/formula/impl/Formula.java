package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import java.util.ArrayList;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;

/**
 * The Formula class contains all the operands and operators
 * provided by the user. Also, the value resulting of the formula
 * computation.
 */
public class Formula implements ICellContent, IFormulaContent {
    protected String content;
    protected float value;
    protected ArrayList<IFormulaContent> formulaContent;

    public Formula(String content){
        this.content = content;
        // Remove this after testing
        this.value = 0;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "content='" + content + '\'' +
                ", value=" + value +
                '}';
    }
}
