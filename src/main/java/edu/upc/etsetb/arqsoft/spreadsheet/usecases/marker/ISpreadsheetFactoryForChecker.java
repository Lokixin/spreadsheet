/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.marker;

import edu.upc.etsetb.arqsoft.spreadsheet.controllers.SpreadSheetController;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.UnknownFactoryException;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public interface ISpreadsheetFactoryForChecker {
    
    public static ISpreadsheetControllerForChecker createSpreadsheetController() throws UnknownFactoryException {
        return new SpreadSheetController();
    }
}
