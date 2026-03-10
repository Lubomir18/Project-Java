package SVGProject.Commands;

import SVGProject.Console;

public class helpCommand {

    public static void CommandHelp(){

        Console.log("Available Commands");
        Console.log("Help - Shows all commands");
        Console.log("Help Open - Info about Open Command");
        Console.log("Help Close - Info about Close Command");
        Console.log("Help Save - Info about Save Command");
        Console.log("Help Save AS - Info about Save AS Command");
        Console.log("Help Exit - Info about Exit Command");
        Console.log("Open");
        Console.log("Close");
        Console.log("Save");
        Console.log("Save AS");
        Console.log("Exit");

    }

    public static void CommandHelpCommands(String command){

        if(command.equalsIgnoreCase("Open")) {
            Console.log("Command Open. Makes it easier to open a specific file.");
            Console.log("While opening a specific file you must be specific to its file location.");
        }
        else if(command.equalsIgnoreCase("Close")) {
            Console.log("Command Close. Closes the File opened by the user without Saving it.");
        }
        else if(command.equalsIgnoreCase("Save")) {
            Console.log("Command Save. Overrides the File in the same location and name.");
        }
        else if(command.equalsIgnoreCase("Save AS")) {
            Console.log("Command Save AS. The User can Save the File to a new Directory.");
        }
        else if(command.equalsIgnoreCase("Exit")) {
            Console.log("Command Exit. Exiting the Program without Saving.");
        }
        else{
            Console.log("No Help found for this Command.");
        }


    }

}
