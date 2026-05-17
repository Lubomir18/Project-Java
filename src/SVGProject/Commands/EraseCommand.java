package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeRepository;

public class EraseCommand implements Command {

    private ShapeRepository repo;

    public EraseCommand(ShapeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            Console.log("Usage: erase <n>");
            return;
        }

        try {
            int index = Integer.parseInt(args[1]);
            repo.erase(index);
        } catch (Exception e) {
            Console.log("Invalid erase command");
        }
    }
}