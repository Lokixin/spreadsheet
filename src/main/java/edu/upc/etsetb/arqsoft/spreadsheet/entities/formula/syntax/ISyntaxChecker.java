/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.syntax;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;

/**
 *
 * @author JuanCarlos
 */
public interface ISyntaxChecker {
    
    public List<IToken> getTokens() ;
    
    public void check(String input) throws SyntaxException ;
    
    public String result2String();
    
}
