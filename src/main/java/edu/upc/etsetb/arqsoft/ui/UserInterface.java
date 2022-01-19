package edu.upc.etsetb.arqsoft.ui;

import edu.upc.etsetb.arqsoft.controllers.CommandManager;
import edu.upc.etsetb.arqsoft.controllers.InvalidCommandException;
import edu.upc.etsetb.arqsoft.controllers.InvalidNumberOfArgumentsException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Textual Menu in charge of interacting with the user. It
 * requests all the information needed and the controller collects
 * it to perform the requested operations.
 */
public class UserInterface {

    protected CommandManager commandManager;
    protected ArrayList<String> optionMenu;
    protected Scanner cmdReader;

    public UserInterface() {
        this.commandManager = new CommandManager();
        this.optionMenu = this.createOptions();
        this.cmdReader = new Scanner(System.in);
    }

    public ArrayList<String> createOptions() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("RF <path to file> ---- reads a set of commands from file");
        options.add("C ---- creates a new spreadsheet from scratch");
        options.add("E <cell coordinate> <new cell content> ---- updates the content of the cell");
        options.add("L <path to SV2 file> ---- loads a spreadsheet from file");
        options.add("S <SV2 file pathname> ---- saves the current spreadsheet into the given file");
        return options;
    }

    public void displayOptions() {
        for (String option : this.optionMenu) {
            System.out.println(option);
        }
    }

    public String readCommand() {
        return this.cmdReader.nextLine();
    }

    public void mainLoop() {
        while (true) {
            try {
                this.displayOptions();
                System.out.print("Introduce a command: ");
                String receivedCmd = readCommand();
                if (receivedCmd.equalsIgnoreCase("x")) break;
                this.commandManager.receiveCmd(receivedCmd);
            }
            catch (InvalidNumberOfArgumentsException exception) {
                System.err.println(exception.getMessage());
            }
            catch (InvalidCommandException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

}
