/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.syntax.SyntaxException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.syntax.ISyntaxChecker;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class SyntaxCheckerImplTester {

    public static void main(String[] args) {
        String[] in = {
            "13,2",
            "/A1",
            "*A1",
            ")A1",
            ":A1",
            ";A1",
            ",A1",
            "+FUNCTA(FUNCTB(FUNCTC(A1;A2;A4:A6);B1:B7);C3)",
            "+A",
            "(A1:A2)",
            "()",
            "(A1+A2)+",
            "(A1+A2)+B",
            "A1A2:A3",
            "A:A1",
            ":A1",
            "A1:A2A3",
            "A1:A",
            "A1:",
            "+12+13,2+SUMA(A27:A45",
            "+12+13,2+SUMA(A27:A45)",
            "+12+13,2+SUMA(B23:C47/",
            "+12+13,2+SUMA(B23:C47)",
            "+12+13,2+SUMA(/A1+B2*A12-B12+CA112)",
            "+12+13,2+SUMA(A1+B2*AAA()B12+CA112)",
            "+12+13,2+SUMA(A1+B2*A12-B12+CA112",
            "+12+13,2+SUMA(A1+B2*A12-B12+CA112)",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20)) +B12)+CA112",
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
        ISyntaxChecker parser = null;
        try {
            IFormulaExpressionFactory factory = IFormulaExpressionFactory.getInstance("DEFAULT");
            parser = factory.createSyntaxChecker(factory);
        } catch (UnkownFactoryException ex) {
            System.out.println("ERROR WHEN TRYING TO INSTANTIATE THE FACTORY. DETAILS: " + ex.getMessage());
            System.out.println("ENDING EXECUTION...");
            System.exit(-1);

        }
        for (String input : in) {
            try {
                System.out.println("\n\n" + input);
                parser.check(input);
                System.out.println("Checking OK. Tokens found: " + parser.result2String());
            } catch (SyntaxException ex) {
                System.out.println("An error has occurred while parsing. Details follow. " + ex.getMessage());
            }

        }
    }

}
