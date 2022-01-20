/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.upc.etsetb.arqsoft.spreadsheet.usecases.marker;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.CircularDependencyException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.ContentException;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.NoNumberException;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public interface ISpreadsheetControllerForChecker {
    
    public void setCellContent(String cellCoord, String strContent)
            throws ContentException, BadCoordinateException, CircularDependencyException;
    
    public double getCellContentAsDouble(String coord) throws BadCoordinateException, NoNumberException;
    
    public String getCellContentAsString(String cooord) throws BadCoordinateException;
    
}
