package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula;

import edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix.ComponentVisitor;

/**
 * Interface encapsulating all the possible types of content
 * within a formula (operands and operators).
 */

public interface IFormulaContent {
    public void acceptVisitor(ComponentVisitor visitor);
}
