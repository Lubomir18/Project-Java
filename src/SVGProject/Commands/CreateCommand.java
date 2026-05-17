package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.Circle;
import SVGProject.Shape.Rectangle;
import SVGProject.Shape.ShapeBase;
import SVGProject.Shape.ShapeRepository;

public class CreateCommand implements Command {

    private ShapeRepository shapeRepository;

    public CreateCommand(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void execute(String[] args) {
        try{
            ShapeBase shape;

            if(args[1].equalsIgnoreCase("circle")){

                if (args.length < 5) {
                    Console.log("Usage: create circle cx cy r [color]");
                    return;
                }

                String fill = "black";

                if(args.length >= 6){
                    fill = args[5];
                }

                shape = new Circle(
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        fill
                );
            }
            else if(args[1].equalsIgnoreCase("rectangle")){

                if (args.length < 6) {
                    Console.log("Usage: create rectangle x y width height [color]");
                    return;
                }

                String fill = "black";

                if(args.length >= 7){
                    fill = args[6];
                }

                shape = new Rectangle(
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5]),
                        fill
                );
            } else {
                Console.log("Unknown shape: " + args[1]);
                return;
            }

            shapeRepository.add(shape);

            Console.log("Created " + shape.info());
        } catch (RuntimeException e) {
            Console.log("Error Creating Shape");
        }
    }
}