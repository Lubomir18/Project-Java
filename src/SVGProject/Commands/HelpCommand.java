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
        Console.log("create circle ...- Create circle");
        Console.log("create rectangle - Create rectangle");
        Console.log("print            - Print all shapes");
        Console.log("help [command]   - Show help");
        Console.log("exit             - Exit program");
    }


    public static void printCommand(String command){



    }

}
