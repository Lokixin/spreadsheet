package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

import java.util.ArrayList;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IExpressionGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;

/**
 * The Formula class contains all the operands and operators
 * provided by the user. Also, the value resulting of the formula
 * computation.
 */
public class Formula implements ICellContent, IFormulaContent {
    protected String content;
    protected float value;
    protected ArrayList<IToken> formulaContent;

    public Formula(String content){
        this.content = content;
        this.formulaContent = new ArrayList<>();

        this.value = this.generatePostfix();

    }

    private float generatePostfix() {
        IExpressionGenerator gen = null;
        try {
            IFormulaExpressionFactory factory = IFormulaExpressionFactory.getInstance("DEFAULT");
            gen = factory.createExpressionGenerator("postfix",factory);
        } catch (Exception ex)  {
            System.out.println(ex.getMessage());
            System.out.println("Error while trying to build the postfix generator. Details follow. " + ex.getMessage());
            System.exit(-1);
        }

        try {
            gen.generateFromString(this.content.substring(1));
            for (IToken c : gen.getResult()) {
                System.out.println("Token type: " + c.getType().toString());
                System.out.println(c.getText());
                this.formulaContent.add(c);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error while trying to generate the postfix expression. Details follow. " + ex.getMessage());

        }

        return 0;
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
