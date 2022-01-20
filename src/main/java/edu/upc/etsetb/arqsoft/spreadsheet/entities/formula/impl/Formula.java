package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import java.util.ArrayList;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.NoNumericValue;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;


/**
 * The Formula class contains all the operands and operators
 * provided by the user. Also, the value resulting of the formula
 * computation.
 */
public class Formula implements ICellContent {
    protected String content;
    protected double value;
    protected ArrayList<IFormulaContent> formulaContent;

    public Formula(String content){
        this.content = content;
        this.formulaContent = new ArrayList<>();
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void addComponent(IFormulaContent component){
        this.formulaContent.add(component);
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
