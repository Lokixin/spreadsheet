package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.IOperand;

import java.util.Stack;

public interface IFunction extends IArgument, IOperand {

    public abstract double operate();

}
