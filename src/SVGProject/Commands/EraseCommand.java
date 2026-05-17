package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeBase;
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

            ShapeBase removed = repo.get(index);

            if (removed == null) {
                Console.log("There is no figure number " + index + "!");
                return;
            }

            repo.erase(index);

            Console.log("Erased " + removed.getClass().getSimpleName()
                    + " (" + index + ")");

        } catch (Exception e) {
            Console.log("Invalid erase command");
        }
    }
}
