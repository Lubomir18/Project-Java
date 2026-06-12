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

        return "Available commands:" + System.lineSeparator()
                + "open <file>      - Open SVG file" + System.lineSeparator()
                + "close            - Close current file" + System.lineSeparator()
                + "save             - Save current file" + System.lineSeparator()
                + "saveas <file>    - Save file as new path" + System.lineSeparator()
                + "create circle    - Create circle" + System.lineSeparator()
                + "create rectangle - Create rectangle" + System.lineSeparator()
                + "print            - Print all shapes" + System.lineSeparator()
                + "translate dx dy  - Moves all figures" + System.lineSeparator()
                + "translate n dx dy- Only moves n figure" + System.lineSeparator()
                + "help [command]   - Show help" + System.lineSeparator()
                + "exit             - Exit program";
    }


    public static String printCommand(String command){

        switch (command) {

            case "open":
                return "[command] Open <file>" + System.lineSeparator()
                        + "Opens SVG file and loads shapes.";

            case "close":
                return "[command] Close" + System.lineSeparator()
                        + "Closes current opened file.";

            case "save":
                return "[command] Save" + System.lineSeparator()
                        + "Saves current opened file.";

            case "saveas":
                return "[command] Saveas <file>" + System.lineSeparator()
                        + "Saves file with new name.";

            case "create":
                return "[command] Create" + System.lineSeparator()
                        + "Create circle cx cy r color" + System.lineSeparator()
                        + "Create rectangle x y width height color";

            case "print":
                return "[command] Print" + System.lineSeparator()
                        + "Prints all shapes.";

            case "erase":
                return "[command] Erase <n>" + System.lineSeparator()
                        + "Deletes figure by number.";

            case "translate":
                return "Translate dx dy - Moves all figures" + System.lineSeparator()
                        + "Translate n dx dy - Moves only n selected figure" + System.lineSeparator()
                        + "To see what figure to select, use command print";

            case "help":
                return "[command] Help" + System.lineSeparator()
                        + "Shows help information.";

            case "exit":
                return "[command] Exit" + System.lineSeparator()
                        + "Exits application.";

            default:
                return "No help found for command: " + command;
        }

    }

}
