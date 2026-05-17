package SVGProject.CommandProcess;

import SVGProject.Commands.*;
import SVGProject.FileControl.FileManager;
import SVGProject.Shape.ShapeRepository;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcess {

    private Map<String, Command> commands = new HashMap<>();
    private ShapeRepository shapeRepository = new ShapeRepository();
    private FileManager fileManager = new FileManager(shapeRepository);

    public CommandProcess() {
        commands.put("open", new OpenCommand(fileManager));
        commands.put("close", new CloseCommand(fileManager));
        commands.put("save", new SaveCommand(fileManager));
        commands.put("saveas", new SaveAsCommand(fileManager));
        commands.put("help", new HelpCommand(fileManager));
        commands.put("exit", new ExitCommand(fileManager));
        commands.put("print", new PrintCommand(shapeRepository));
        commands.put("create", new CreateCommand(shapeRepository));
        commands.put("erase", new EraseCommand(shapeRepository));
        commands.put("translate", new TranslateCommand(shapeRepository));
        commands.put("within", new WithinCommand(shapeRepository));
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            Console.log("> ");
            String input = scanner.nextLine();

            String[] parts = input.split(" ");
            String commandName = parts[0].toLowerCase();

            Command command = commands.get(commandName);

            if(command != null){
                command.execute(parts);
            } else {
                Console.log("Unknown command");
            }
        }
    }

}
