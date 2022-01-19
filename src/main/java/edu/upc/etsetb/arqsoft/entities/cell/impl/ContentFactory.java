package edu.upc.etsetb.arqsoft.entities.cell.impl;

import edu.upc.etsetb.arqsoft.entities.cell.ICellContent;
import edu.upc.etsetb.arqsoft.entities.cell.formula.impl.Formula;

public class ContentFactory {

    /**
     * Helper function to check if a string contains only numeric content.
     * @param str
     * @return bool
     */
    public boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * Decide the cell's content type: Text, number, formula
     * @param content
     * @return
     */
    public EContentType decideContent(String content){
        if (content.startsWith("=")) return EContentType.FORMULA;
        if (this.isNumeric(content)) return EContentType.NUMERIC;
        return EContentType.TEXTUAL;
    }

    /**
     * Create a cell with the appropriate content and coordinate.
     * @param content
     * @return
     */
    public ICellContent makeContent(String content){

        EContentType contentType = this.decideContent(content);
        ICellContent cellContent = null;

        switch (contentType){
            case NUMERIC:
                return new Numerical(content);

            case TEXTUAL:
                return new Textual(content);

            case FORMULA:
                //TO BE IMPLEMENTED
                return new Formula(content);
            default:
                // Define a custom exception. This is a placeholder.
                throw new RuntimeException("Invalid type of cell");
        }

    }
}
