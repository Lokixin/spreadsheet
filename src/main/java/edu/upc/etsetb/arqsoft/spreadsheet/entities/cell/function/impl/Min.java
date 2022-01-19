package edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.AFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.IArgument;

import java.util.ArrayList;

/**
 * Min class is in charge of computing the minimum value across all the arguments of the function.
 */
public class Min extends AFunction {

    public Min(ArrayList<IArgument> functionArguments) {
        super(functionArguments);
    }
}
