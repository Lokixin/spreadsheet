package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;


public class OpenBracket implements IOperand {


    @Override
    public void acceptVisitor(ComponentVisitor visitor) {
        visitor.visitOpenBracket(this);
    }
}
