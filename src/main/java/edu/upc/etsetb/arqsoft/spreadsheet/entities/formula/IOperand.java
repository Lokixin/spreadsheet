package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula;

import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

/**
 * The interface IOperand encapsulates all possible operands
 * present in a formula. These are: Cells, Numerical and Functions
 */
public interface IOperand extends IFormulaContent {

    public void acceptVisitor(ComponentVisitor visitor);
}
