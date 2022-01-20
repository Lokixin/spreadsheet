package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

import java.util.Stack;

public class MaxFunction extends AFunction {


    public MaxFunction(){}

    public double operate(){
        double max = 0;
        if(!this.arguments.isEmpty()) {
            max = this.arguments.get(0);
        }else{
            return max;
        }

        for (Double num: this.arguments){
            if (num > max){
                max = num;
            }
        }

        this.arguments.clear();
        return max;
    }
}
