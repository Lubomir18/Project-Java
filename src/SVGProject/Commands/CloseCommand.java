package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class CloseCommand implements Command {
    private FileManager fileManager;

    public CloseCommand(FileManager fileManager){
        this.fileManager = fileManager;
    }

    public String execute(String[] args) {
        return fileManager.close();
    }
}
