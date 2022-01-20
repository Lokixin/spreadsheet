package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

public abstract class AFunction implements IArgument, IFunction, IOperand {

    public AFunction(){}



    @Override
    public void acceptVisitor(ComponentVisitor visitor) {
        visitor.visitFunction(this);
    }
}
