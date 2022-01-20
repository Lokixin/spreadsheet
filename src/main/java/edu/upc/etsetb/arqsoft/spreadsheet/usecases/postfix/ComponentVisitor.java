package edu.upc.etsetb.arqsoft.spreadsheet.usecases.postfix;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.ClosingBrackent;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.function.OpenBracket;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Coordinate;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.NoNumericValue;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl.Operator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.AFunction;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.functions.IFunction;

import java.util.Stack;


public class ComponentVisitor implements IComponentVisitor {

    protected Stack<Double> stack;
    protected Spreadsheet spreadsheet;
    protected boolean isFunctionArgument;
    protected AFunction currentFunction;

    public ComponentVisitor(Spreadsheet spreadsheet){
        this.spreadsheet = spreadsheet;
        this.stack = new Stack<Double>();
        this.isFunctionArgument = false;
        this.currentFunction = null;
    }

    public double getResult(){
        return this.stack.pop();
    }

    @Override
    public void visitOperator(Operator op) {
        try{
            double secondOperand = stack.pop();
            double firstOperand = stack.pop();
            double result = op.operate(firstOperand, secondOperand);
            stack.add(result);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void visitANumber(Numerical number) {
        if (isFunctionArgument){
            this.currentFunction.addArgument(number.getValue());
        }else {
            this.stack.add(number.getValue());
        }

    }

    @Override
    public void visitFunction(AFunction function) {
        /*System.out.println("Stack passed in visitFunction: ");
        this.stack.forEach(System.out::println);

        function.setStack(this.stack);
        this.stack.add(function.operate());*/
        this.currentFunction = function;
    }


    @Override
    public void visitCoordinate(Coordinate coordinate) {
        try {
            Cell cell = this.spreadsheet.getCells().get(coordinate);

            if (cell == null) {
                //We suppose that empty cells can be interpreted as 0.0
                if(isFunctionArgument){
                    this.currentFunction.addArgument(0.0);
                }else{
                    this.stack.add(0.0);
                }
            } else {
                if (isFunctionArgument){
                    this.currentFunction.addArgument(cell.getContent().getValue());
                }else{
                    stack.add(cell.getContent().getValue());
                }
            }
        }catch (NoNumericValue e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void visitOpenBracket(OpenBracket openBracket) {
        this.isFunctionArgument = true;
    }

    @Override
    public void visitClosingBracket(ClosingBrackent closingBrackent) {
        this.stack.add(this.currentFunction.operate());
        this.isFunctionArgument = false;
    }
}
