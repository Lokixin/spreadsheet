/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.UnkownFactoryException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.BadTokenException;
import edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.tokens.Tokenizer;
import java.util.ArrayList;
import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.ITokenizer;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class TokenizerImplTester {

    public static void main(String[] args) throws BadTokenException {
        String[] in = {
            "/A", "+A", "+12+13,2+SUM(A27:A45", "+12+13,2+SUM(B23:C47/",
            "(A1:A2)", "()",
            "(A1+A2)+", "(A1+A2)+B",
            "A1A2:A3", "A:A1", ":A1", "A1:A2A3", "A1:A", "A1:",
            "+12+13,2+SUMA(/A1+B2*AAA()B12+CA112",
            "+12+13,2+SUMA(/A1+B2*A12-B12+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))+B12)+CA112",
            "+12 + 13,2+(SUMA(A1:B5;C7;SUMA(C8:C20))  ?  +B12)+CA112",
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
        ITokenizer tokenizer = null;
        IFormulaExpressionFactory factory = null;
        try {
            factory = IFormulaExpressionFactory.getInstance("DEFAULT");
            tokenizer = factory.createTokenizer(factory);
        } catch (UnkownFactoryException ex) {
            System.out.println("An error has occurred while trying to "
                    + "create the tokenizer. Details: " + ex.getMessage());
            ex.printStackTrace();
            System.out.println("ENDING EXECUTION...");
            System.exit(-1);
        }

        for (int i = 0; i < in.length; i++) {
            List<IToken> result = new ArrayList<IToken>();
            System.out.println(in[i]);
            try {
                tokenizer.tokenize(in[i]);
                System.out.println(((Tokenizer) tokenizer).result2String());
            } catch (BadTokenException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Tokens found before the error: " + ((Tokenizer) tokenizer).result2String());
            }
            System.out.println();
        }
    }

}
