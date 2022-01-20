package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.cell.impl.Numerical;

import java.util.Stack;

public class MinFunction extends AFunction {

    public MinFunction(){}

    @Override
    public double operate() {
        double min = 0;
        if(!this.arguments.isEmpty()) {
            min = this.arguments.get(0);
        }else{
            return min;
        }

        for (Double num: this.arguments){
            if (num < min){
                min = num;
            }
        }

        this.arguments.clear();
        return min;
    }


}
