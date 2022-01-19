package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.Operator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.IFunction;

import java.util.function.IntFunction;

public interface IComponentVisitor {
    public abstract void visitOperator(Operator op);
    public abstract void visitANumber(Numerical number);
    public abstract void visitFunction(IFunction function);
    public abstract void visitCoordinate(Coordinate coordinate);
}
