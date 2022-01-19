/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens;

import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;

/**
 * Interface that any class breaking the input string in a sequence of tokens 
 * (as enummerated in {@link edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.TokenType}), shall have to implement for using the syntax 
 * checker and the postfix generator included in this module; this package comes
 * with the class Tokenizer that implements this interface, within package 
 * edu.upc.etsetb.arqsoft.spreadsheet.usecases.tokens, and that you can use
 * 
 * @author Juan Carlos Cruellas
 */
public interface ITokenizer {
    
    /**
     * Method that analizes the input String str and gets all the tokens that 
     * are present in it.
     * 
     * @param str the string containing the tokens
     * 
     * @throws BadTokenException if some non allowed character is present or some 
     * error happesn during the analysis of the string
     */
    public void tokenize(String str) throws BadTokenException ;
    
    /**
     * Method for returning an ordered list of found tokens in the input String.
     * 
     * @return the ordered list of tokens in the order they appeared in the 
     * input String
     */
    public List<IToken> getResult() ;
    
}
