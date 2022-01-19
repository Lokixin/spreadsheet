/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.FormulaException;
import java.util.List;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.IFormulaExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 * 
 * This is the interface of all the generators of the different types of 
 * expresions for a formula (postfix, ast, etc)
 */
public interface IExpressionGenerator {

    public void generateFromString(String input) throws FormulaException;

    public String tokens2String();
    
    public List<IToken> getResult();


}
