package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeRepository;

public class WithinCommand implements Command {

    private ShapeRepository repo;

    public WithinCommand(ShapeRepository repo) {
        this.repo = repo;
    }

    @Override
    public String execute(String[] args) {

        if (args.length < 2) {
            return "Usage:" + System.lineSeparator()
                    + "within circle cx cy r" + System.lineSeparator()
                    + "within rectangle x y width height";
        }

        try  {
            if(args[1].equalsIgnoreCase("circle")){

                if (args.length < 5) {
                    return "Usage: within circle cx cy r";
                }

                double cx = Double.parseDouble(args[2]);
                double cy = Double.parseDouble(args[3]);
                double r =  Double.parseDouble(args[4]);

                return repo.printWithinCircle(cx, cy, r);

            }else if (args[1].equalsIgnoreCase("rectangle")){

                if (args.length < 6) {
                    return "Usage: within rectangle x y width height";
                }

                double cx = Double.parseDouble(args[2]);
                double cy = Double.parseDouble(args[3]);
                double width = Double.parseDouble(args[4]);
                double height = Double.parseDouble(args[5]);

                return repo.printWithinRectangle(cx, cy, width, height);

            } else {
                return "Unknown area: " + args[1];
            }
        } catch (Exception e){
            return "Invalid within command";
        }
    }
}
