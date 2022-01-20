package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;



public class MeanFunction extends AFunction{

    @Override
    public double operate() {
        double average = 0;
        for (Double num : this.arguments){
            average += num;
        }
        average /= this.arguments.size();
        return average;
    }
}
