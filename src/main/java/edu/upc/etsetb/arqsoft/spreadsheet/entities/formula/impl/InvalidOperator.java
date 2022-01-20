package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.impl;

public class InvalidOperator extends Exception{
    public InvalidOperator(){

    }

    public InvalidOperator(String msg){
        super(msg);
    }
}
