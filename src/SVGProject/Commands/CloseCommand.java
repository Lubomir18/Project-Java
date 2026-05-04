package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class CloseCommand implements Command {
    private FileManager fileManager;

    public CloseCommand(FileManager fileManager){
        this.fileManager = fileManager;
    }

    public void execute(String[] args) {
        fileManager.close();
    }
}
