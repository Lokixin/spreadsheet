package edu.upc.etsetb.arqsoft.spreadsheet.controllers;
import java.util.HashMap;

/**
 * The CommandManager class is responsible for interpreting the commands received in the
 * user interface and pass them to the spreadsheet controller.
 */
public class CommandManager {

    protected HashMap<String, Integer> cmdOptions;
    protected SpreadSheetController sheetController;

    public CommandManager(){
        this.cmdOptions = this.buildOptions();
        this.sheetController = new SpreadSheetController();
    }

    public void receiveCmd(String rawCmd){
        String[] command = rawCmd.split(" ");
        this.checkCmd(command);
        String msg = this.sheetController.controlCommand(command);
        System.out.println("\nCommand result: \n" + msg + "\n");
    }

    public void checkCmd(String[] cmd) throws  InvalidCommandException, InvalidNumberOfArgumentsException{
        if (this.cmdOptions.get(cmd[0]) != null ){
            if (this.cmdOptions.get(cmd[0]) == cmd.length - 1) {
                return;
            }else {
                throw new InvalidNumberOfArgumentsException("Incorrect number of arguments");
            }
        }else {
            throw new InvalidCommandException("The command does not exist");
        }
    }

    private HashMap<String, Integer> buildOptions(){
        HashMap<String, Integer> cmdOptions = new HashMap<>();
        cmdOptions.put("RF", 1);
        cmdOptions.put("C", 0);
        cmdOptions.put("E", 2);
        cmdOptions.put("L", 1);
        cmdOptions.put("S", 1);
        return cmdOptions;
    }
}
