/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression;


import edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.postfix.DefaultExpressionFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.TokenType;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.UnknownTokenTypeException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.IToken;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.tokens.ITokenizer;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.syntax.ISyntaxChecker;

/**
 * <p><b>IMPORTANT NOTE: THE USAGE OF THE CLASESS PRESENT WITHIN THIS MODULE IS COMPLETELY OPTIONAL.</b></p>
 * <p>An interface that serves as root of the Abstract Factory Design Pattern; if 
 * you do not want to use the default factory delivered in this package, you will
 * have to modify the method getInstance for allowing to return YOUR concrete
 * factory and SUPPRESSING the return of DefaultFactory; when you do that, you
 * will have to remove the import of the DefaultFactory; the list of methods 
 * present in this class is the set of factory methods used by the classes that 
 * generate a postfix expression OF TOKENS from the textual representation of a 
 * formula passed in a string</p>
 * 
 * <p><b>IMPORTANT WARNING 1:</b> Using these classes will have a penalty in the
 * final mark of the program, as detailed below:</p>
 * <ul>
 * <li><p>Using createToken(),
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.tokens.Token},
 * createTokenizer() and
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.tokens.Tokenizer} shall
 * substract 0,15 points to the final mark.</p></li>
 * <li><p>Using createSyntaxChecker(), and
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.syntax.SyntaxChecker}
 * shall substract 0,30 points to the final mark.</p></li>
 * <li><P>Using createPostFixGenerator(), and
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.postfix.PostfixGenerator}
 * shall substract 0,55 points to the final mark.</p></li>
 * </ul>
 
 * * <b>IMPORTANT WARNING 2:</b> In the Test packages of the maven project 
 * you will find some programs that run 
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.tokens.Tokenizer},
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.syntax.SyntaxChecker}, and  
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.postfix.PostfixGenerator}
 * <b>You can run TokenizerIntTest and SyntaxChecerIntTesting without
 * adding anything to the code; however, PostFixGeneratorIntTesting shall require that 
 * you implement all the classes and methods listed in the documentation of 
 * {@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.postfix}</b>.
 * 
 *
 * @author Juan Carlos Cruellas
 */
public interface IFormulaExpressionFactory {
    
    /**
     * Static method for creating and returning a concrete factory implemented by a 
 subclass of ExpressionFactory.
     * 
     * @param which string identifying the concrete factory to create. 
     * @return the concrete factory; note that if you do not modify the code of 
     * this method, and you pass the string "DEFAULT" as argument, it will 
     * create and return an instance of the partially implemented default factory 
     * ({@link edu.upc.etsetb.arqsoft.spreadsheet.usecases.formula.postfix.DefaultExpressionFactory}).
     * You are free of building your own concrete factory for creating any object 
     * that your program requires
     * @throws UnkownFactoryException in case the argument does not properly 
     * identify any concrete factory.
     */
    public static IFormulaExpressionFactory getInstance(String which) 
            throws UnkownFactoryException {
        if (which.equalsIgnoreCase("DEFAULT")) {
            return new DefaultExpressionFactory();
        } else {
            throw new UnkownFactoryException("Unknown factory code \'" + which + "\'.");
        }
    }

    /**
     * Factory method for creating a new Token object.
     *
     * @param tokenType an object identifying the type of the token. The
     * specific object shall be implementation-dependent, and its
     * class/enumerated type shall be declared as implementing the TokenType
     * interface
     *
     * @param tokenText the text of the token
     *
     * @return the Token object. Its specific class will depend on the
     * implementation
     *
     * @throws UnknownTokenTypeException if the object passed as first argument
     * does not correspond to any token as per implementation
     */
    public abstract IToken createToken(TokenType tokenType, String tokenText)
            throws UnknownTokenTypeException;

    /**
     * Factory method for creating a new Tokenizer
     * 
     * @param factory the factory for objects that build the suitable expression 
     * for the formula
     *
     * @return the Tokenizer object
     */
    public abstract ITokenizer createTokenizer(IFormulaExpressionFactory factory);

    /**
     * Factory method for creating a new syntax checker
     * 
     * @param factory the factory for objects that build the suitable expression 
     *
     * @return the ISyntaxChecker object
     */
    public abstract ISyntaxChecker createSyntaxChecker(IFormulaExpressionFactory factory);
    

    /**
     * Factory method for creating a new postfix expression generator
     * 
     * @param type the type of expression to build ("postfix" for the spreadsheet 
     * problem)
     * 
     * @param factory the factory for objects that build the suitable expression 
     *
     * @return the PostFixGenerator object
     * @throws edu.upc.etsetb.arqsoft.spreadsheet.entities.formula.expression.UnknownExpressionGeneratorException 
     * if there is an error while generating the specific expression for the formula
     */
    public abstract IExpressionGenerator createExpressionGenerator(String type,
            IFormulaExpressionFactory factory)
            throws UnknownExpressionGeneratorException;

}
