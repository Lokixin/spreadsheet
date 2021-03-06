package edu.upc.etsetb.arqsoft.entities.cell.function;

import edu.upc.etsetb.arqsoft.entities.cell.formula.IOperand;

import java.util.ArrayList;

/**
 * Abstract class encapsulating every possible function class.
 * Functions that can be computed are:
 * - MIN
 * - MAX
 * - MEAN
 * - SUM
 */
public abstract class AFunction implements IOperand, IArgument {

    protected ArrayList<IArgument> functionArguments;

    public AFunction(ArrayList<IArgument> functionArguments) {
        this.functionArguments = functionArguments;
    }
}
