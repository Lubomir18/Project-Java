package SVGProject;

import SVGProject.Commands.*;
import SVGProject.FileControl.FileManager;

import java.util.HashMap;
import java.util.Map;

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

}
