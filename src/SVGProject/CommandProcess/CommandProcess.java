package SVGProject.CommandProcess;

import SVGProject.FileControl.FileManager;
import SVGProject.Commands.OpenCommand;
import SVGProject.Commands.CloseCommand;
import SVGProject.Commands.SaveCommand;
import SVGProject.Commands.SaveAsCommand;
import SVGProject.Commands.HelpCommand;
import SVGProject.Commands.ExitCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandProcess {

    private Map<String, Command> commands = new HashMap<>();
    private FileManager fileManager = new FileManager();

    public CommandProcess() {
        commands.put("open", new OpenCommand(fileManager));
        commands.put("close", new CloseCommand(fileManager));
        commands.put("save", new SaveCommand(fileManager));
        commands.put("saveAs", new SaveAsCommand(fileManager));
        commands.put("help", new HelpCommand(fileManager));
        commands.put("exit", new ExitCommand(fileManager));
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("> ");
            String input = scanner.nextLine();

            String[] parts = input.split(" ");
            String commandName = parts[0].toLowerCase();

            Command command = commands.get(commandName);

            if(command != null){
                command.execute(parts);
            } else {
                System.out.println("Unknown command");
            }
        }
    }

}
