package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IFormulaContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.ComponentFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;

import java.util.Iterator;
import java.util.List;

public class PostfixEvaluator {

    protected ComponentVisitor visitor;
    protected ComponentFactory factory;

    public PostfixEvaluator(Spreadsheet spreadsheet){
        this.visitor = new ComponentVisitor(spreadsheet);
        this.factory = new ComponentFactory();
    }

    public double evaluate(List<IToken> contents){
        Iterator<IToken> it = contents.iterator();

        IFormulaContent component = null;
        while (it.hasNext()){
            component = factory.makeComponent(it.next());
            if (component == null) continue;
            System.out.println("Component: " + component);
            component.acceptVisitor(this.visitor);
        }
        return visitor.getResult();
    }
}
