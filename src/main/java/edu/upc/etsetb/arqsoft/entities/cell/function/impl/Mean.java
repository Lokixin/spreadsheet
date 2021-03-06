package edu.upc.etsetb.arqsoft.entities.cell.function.impl;

import edu.upc.etsetb.arqsoft.entities.cell.function.AFunction;
import edu.upc.etsetb.arqsoft.entities.cell.function.IArgument;

import java.util.ArrayList;

/**
 * Min class is in charge of computing the mean value of all the arguments of the function.
 */
public class Mean extends AFunction {

    public Mean(ArrayList<IArgument> functionArguments) {
        super(functionArguments);
    }
}