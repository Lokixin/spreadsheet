package edu.upc.etsetb.arqsoft.entities.cell.function.impl;

import edu.upc.etsetb.arqsoft.entities.cell.function.AFunction;
import edu.upc.etsetb.arqsoft.entities.cell.function.IArgument;

import java.util.ArrayList;

/**
 * Min class is in charge of computing the sum of all the arguments of the function.
 */
public class Sum extends AFunction {

    public Sum(ArrayList<IArgument> functionArguments) {
        super(functionArguments);
    }
}
