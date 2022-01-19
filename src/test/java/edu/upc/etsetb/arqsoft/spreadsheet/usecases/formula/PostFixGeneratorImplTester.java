/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IExpressionGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class PostFixGeneratorImplTester {

    public static void main(String[] args) {
        String[] in = {
            "C20+2*10",
            "20/(5+5)",
            "100/(5+(25/5))",
            "A1*10-5",
            "(A5*4)/(A2+A2)",
            "100/(A5+(A5*A5/5))",
            "(A5*4)/(A2+A2)+SUMA(1;2;3;4;5)",
            "(A5*4)/(A2+A2)+SUMA(A1;A2;3;4;5)",
            "(A5*4)/(A2+A2)+SUMA(A1;A2;3;4;5;A6:A12)"
        };
        IExpressionGenerator gen = null;
        try {
            IFormulaExpressionFactory factory = IFormulaExpressionFactory.getInstance("DEFAULT");
            gen = factory.createExpressionGenerator("postfix",factory);
        } catch (Exception ex)  {
            System.out.println(ex.getMessage());
            System.out.println("Error while trying to build the postfix generator. Details follow. " + ex.getMessage());
            System.exit(-1);
        }

        for (String input : in) {
            try {
                System.out.println("\n\n" + input);
                gen.generateFromString(input);
                StringBuilder result = new StringBuilder();
                
                for (IToken c : gen.getResult()) {
                    result.append(c.getText()).append(" ");
                }
                System.out.println("Postfix generation OK. Tokens: " + result);
                System.out.println("Postfix generation OK. expression: " + gen);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Error while trying to generate the postfix expression. Details follow. " + ex.getMessage());
                continue;
            }
        }
    }

}
