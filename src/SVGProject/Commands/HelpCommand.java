package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class HelpCommand implements Command {

    private FileManager fileManager;

    public HelpCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String[] args) {

        if (args.length == 1) {
            printAll();
            return;
        }

        printCommand(args[1].toLowerCase());

    }

    private void printAll() {

        Console.log("Available commands:");

        Console.log("open <file>      - Open SVG file");
        Console.log("close            - Close current file");
        Console.log("save             - Save current file");
        Console.log("saveas <file>    - Save file as new path");
        Console.log("create circle    - Create circle");
        Console.log("create rectangle - Create rectangle");
        Console.log("print            - Print all shapes");
        Console.log("translate dx dy  - Moves all figures");
        Console.log("translate n dx dy- Only moves n figure ");
        Console.log("help [command]   - Show help");
        Console.log("exit             - Exit program");
    }


    public static void printCommand(String command){

        switch (command) {

            case "open":
                Console.log("[command] Open <file>");
                Console.log("Opens SVG file and loads shapes.");
                break;

            case "close":
                Console.log("[command] Close");
                Console.log("Closes current opened file.");
                break;

            case "save":
                Console.log("[command] Save");
                Console.log("Saves current opened file.");
                break;

            case "saveas":
                Console.log("[command] Saveas <file>");
                Console.log("Saves file with new name.");
                break;

            case "create":
                Console.log("[command] Create");
                Console.log("Create circle cx cy r color");
                Console.log("Create rectangle x y width height color");
                break;

            case "print":
                Console.log("[command] Print");
                Console.log("Prints all shapes.");
                break;

            case "erase":
                Console.log("[command] Erase <n>");
                Console.log("Deletes figure by number.");
                break;

            case "translate":
                Console.log("Translate dx dy - Moves all figures");
                Console.log("Translate n dx dy - Moves only n selected figure");
                Console.log("To see what figure to select, use command print");
                break;

            case "help":
                Console.log("[command] Help");
                Console.log("Shows help information.");
                break;

            case "exit":
                Console.log("[command] Exit");
                Console.log("Exits application.");
                break;

            default:
                Console.log("No help found for command: " + command);
        }

    }

}
