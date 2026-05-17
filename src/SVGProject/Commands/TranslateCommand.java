package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeBase;
import SVGProject.Shape.ShapeRepository;

public class TranslateCommand implements Command {

    private ShapeRepository repo;

    public TranslateCommand(ShapeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {

        try {

            if (args.length == 3) {
                // translate dx dy (ALL)
                double dx = Double.parseDouble(args[1]);
                double dy = Double.parseDouble(args[2]);

                repo.translateAll(dx, dy);

                Console.log("Translated all figures");

            } else if (args.length == 4) {
                // translate n dx dy
                int index = Integer.parseInt(args[1]);
                double dx = Double.parseDouble(args[2]);
                double dy = Double.parseDouble(args[3]);

                ShapeBase s = repo.get(index);

                if (s == null) {
                    Console.log("Invalid figure number " + index);
                    return;
                }

                s.translate(dx, dy);

                Console.log("Translated figure (" + index + ")");

            } else {
                Console.log("Usage: translate <n> dx dy OR translate dx dy");
            }

        } catch (Exception e) {
            Console.log("Invalid translate command");
        }
    }
}
