package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.Operator;

import java.util.function.IntFunction;

public class ComponentVisitor implements IComponentVisitor {


    @Override
    public void visitOperator(Operator op) {

    }

    @Override
    public void visitANumber(Numerical number) {

    }

    @Override
    public void visitFunction(IntFunction function) {

    }

    @Override
    public void visitCoordinate(Coordinate coordinate) {

    }
}
