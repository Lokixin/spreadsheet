/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.marker;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.UnknownFactoryException;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public interface ISpreadsheetFactoryForChecker {
    
    public static ISpreadsheetControllerForChecker createSpreadsheetController() throws UnknownFactoryException {
        throw new UnsupportedOperationException("ISpreadsheetFactoryForChecker::"
                + "createSpreadsheetController(). You MUST implement the code of "
                + "this method in this class. The code MUST create a class that "
                + "implements the Java interface ISpreadsheetControllerForChecker. "
                + "This code must create the framework that your program requires ("
                + "your spreadsheet controller, your spreadsheet and the objects required "
                + "for editing the contents of the cells, and evaluate formulas and functions)"
              );
    }
}
