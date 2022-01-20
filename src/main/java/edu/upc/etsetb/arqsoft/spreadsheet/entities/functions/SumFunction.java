package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

public class SumFunction extends AFunction{

    @Override
    public double operate() {
        double acc = 0;
        for (Double num : this.arguments) {
            acc += num;
        }
        return acc;
    }
}
