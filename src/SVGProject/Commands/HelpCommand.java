package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class HelpCommand implements Command {

    private FileManager fileManager;

    public HelpCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public String execute(String[] args) {

        if (args.length == 1) {
            return printAll();
        }

        return printCommand(args[1].toLowerCase());

    }

    private String printAll() {

        return "Available commands:" + "\n"
                + "open <file>      - Open SVG file" + "\n"
                + "close            - Close current file" + "\n"
                + "save             - Save current file" + "\n"
                + "saveas <file>    - Save file as new path" + "\n"
                + "create circle    - Create circle" + "\n"
                + "create rectangle - Create rectangle" + "\n"
                + "print            - Print all shapes" + "\n"
                + "translate dx dy  - Moves all figures" + "\n"
                + "translate n dx dy- Only moves n figure" + "\n"
                + "help [command]   - Show help" + "\n"
                + "exit             - Exit program";
    }


    public static String printCommand(String command){

        switch (command) {

            case "open":
                return "[command] Open <file>" + "\n"
                        + "Opens SVG file and loads shapes.";

            case "close":
                return "[command] Close" + "\n"
                        + "Closes current opened file.";

            case "save":
                return "[command] Save" + "\n"
                        + "Saves current opened file.";

            case "saveas":
                return "[command] Saveas <file>" + "\n"
                        + "Saves file with new name.";

            case "create":
                return "[command] Create" + "\n"
                        + "Create circle cx cy r color" + "\n"
                        + "Create rectangle x y width height color";

            case "print":
                return "[command] Print" + "\n"
                        + "Prints all shapes.";

            case "erase":
                return "[command] Erase <n>" + "\n"
                        + "Deletes figure by number.";

            case "translate":
                return "Translate dx dy - Moves all figures" + "\n"
                        + "Translate n dx dy - Moves only n selected figure" + "\n"
                        + "To see what figure to select, use command print";

            case "help":
                return "[command] Help" + "\n"
                        + "Shows help information.";

            case "exit":
                return "[command] Exit" + "\n"
                        + "Exits application.";

            default:
                return "No help found for command: " + command;
        }

    }

}
