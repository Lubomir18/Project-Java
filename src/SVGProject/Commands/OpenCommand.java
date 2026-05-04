package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.FileControl.FileManager;

public class OpenCommand implements Command {

    private FileManager fileManager;

    public OpenCommand(FileManager fileManager) {
    this.fileManager = fileManager;
    }

    @Override
    public void execute(String[] args) {
        if(args.length < 2){
            System.out.println("Usage: open <file>");
            return;
        }

        fileManager.open(args[1]);
    }
}
