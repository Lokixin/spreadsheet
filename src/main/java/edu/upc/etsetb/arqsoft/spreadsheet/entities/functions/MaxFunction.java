package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import java.util.Stack;

public class MaxFunction extends AFunction {

    protected Stack<Double> stack;
    public MaxFunction(){
    }
    public double operate(){
        double max = 0;
        if(!stack.empty()){
            max = stack.pop();
        }else {
            return 0;
        }

        while (!stack.isEmpty()){
            double newVal = stack.pop();
            if (newVal > max) {
                max = newVal;
            }
        }
        return max;
    }

    public void setStack(Stack<Double> stack) {
        this.stack = stack;
    }
}
