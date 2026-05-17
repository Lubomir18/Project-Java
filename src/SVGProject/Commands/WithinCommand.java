package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.ShapeRepository;

public class WithinCommand implements Command {

    private ShapeRepository repo;

    public WithinCommand(ShapeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void execute(String[] args) {

        if (args.length < 2) {
            Console.log("Usage:");
            Console.log("within circle cx cy r");
            Console.log("within rectangle x y width height");
        }

        try  {
            if(args[1].equalsIgnoreCase("circle")){
                double cx = Double.parseDouble(args[2]);
                double cy = Double.parseDouble(args[3]);
                double r =  Double.parseDouble(args[4]);

                repo.printWithinCircle(cx, cy, r);

            }else if (args[1].equalsIgnoreCase("rectangle")){
                double cx = Double.parseDouble(args[2]);
                double cy = Double.parseDouble(args[3]);
                double width = Double.parseDouble(args[4]);
                double height = Double.parseDouble(args[5]);

                repo.printWithinRectangle(cx, cy, width, height);

            } else {
                Console.log("Unknown area: " + args[1]);
            }
        } catch (Exception e){
            Console.log("Invalid within command");
        }
    }
}
