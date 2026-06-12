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
    public String execute(String[] args) {

        try {

            if (args.length == 3) {

                // translate dx dy (ALL)
                double dx = Double.parseDouble(args[1]);
                double dy = Double.parseDouble(args[2]);

                repo.translateAll(dx, dy);

                return "Translated all figures";

            } else if (args.length == 4) {

                // translate n dx dy
                int index = Integer.parseInt(args[1]);
                double dx = Double.parseDouble(args[2]);
                double dy = Double.parseDouble(args[3]);

                ShapeBase s = repo.get(index);

                if (s == null) {
                    return "Invalid figure number " + index;
                }

                s.translate(dx, dy);

                return "Translated figure (" + index + ")";

            } else {
                return "Usage: translate <n> dx dy OR translate dx dy";
            }

        } catch (Exception e) {
            return "Invalid translate command";
        }
    }
}
