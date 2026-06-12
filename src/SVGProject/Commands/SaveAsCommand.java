package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class SaveAsCommand implements Command {

    private FileManager fileManager;

    public SaveAsCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2) {
            return "Usage: save as <file>";
        }

        return fileManager.saveAs(args[1]);
    }
}
