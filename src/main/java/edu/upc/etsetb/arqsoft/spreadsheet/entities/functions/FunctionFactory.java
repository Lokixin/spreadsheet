package edu.upc.etsetb.arqsoft.spreadsheet.entities.functions;

public class FunctionFactory {

    public FunctionFactory(){}

    public AFunction makeFunction(String functionType){
        switch (functionType){
            case "MIN":
                return new MinFunction();
            case "MAX":
                return new MaxFunction();
            case "PROMEDIO":
                return new MeanFunction();
            case "SUMA":
                return new SumFunction();
            default:
                return null;
        }
    }
}
