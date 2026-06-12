package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeRepository;

public class EraseCommand implements Command {

    private ShapeRepository repo;

    public EraseCommand(ShapeRepository repo) {
        this.repo = repo;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2) {
            return "Usage: erase <n>";
        }

        try {
            int index = Integer.parseInt(args[1]);
            return repo.erase(index);
        } catch (Exception e) {
            return "Invalid erase command";
        }
    }
}