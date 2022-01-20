package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.ClosingBrackent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.OpenBracket;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.Operator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.AFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.IFunction;

public interface IComponentVisitor {
    public abstract void visitOperator(Operator op);
    public abstract void visitANumber(Numerical number);
    public abstract void visitFunction(AFunction function);
    public abstract void visitCoordinate(Coordinate coordinate);
    public abstract void visitOpenBracket(OpenBracket openBracket);
    public abstract void visitClosingBracket(ClosingBrackent closingBrackent);

}
