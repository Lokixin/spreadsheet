package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

import java.util.ArrayList;
import java.util.Stack;

public abstract class AFunction implements IArgument, IFunction, IOperand {


    ArrayList<Double> arguments;

    public AFunction(){
        this.arguments = new ArrayList<>();
    }

    public void addArgument(Double arg){
        this.arguments.add(arg);
    }

    public ArrayList<Double> getArgument(){
        return this.arguments;
    }


    @Override
    public void acceptVisitor(ComponentVisitor visitor) {
        visitor.visitFunction(this);
    }
}
