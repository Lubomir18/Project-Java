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

            if (args.length < 2) {
                Console.log("Usage:");
                Console.log("create circle [cx] [cy] [r] [color]");
                Console.log("create rectangle [x] [y] [width] [height] [color]");
                return;
            }

            if(args[1].equalsIgnoreCase("circle")){

                if (args.length < 5) {
                    Console.log("Usage: create circle cx cy r [color]");
                    return;
                }

                String fill = "black";

                if(args.length >= 6){
                    fill = args[5];
                }

                double cx = Double.parseDouble(args[2]);
                double cy =Double.parseDouble(args[3]);
                double r =Double.parseDouble(args[4]);

                if (r <= 0) {
                    Console.log("Radius must be positive");
                    return;
                }

                shape = new Circle(cx,cy,r,fill);

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

                double x = Double.parseDouble(args[2]);
                double y =Double.parseDouble(args[3]);
                double width =Double.parseDouble(args[4]);
                double height =Double.parseDouble(args[5]);

                if (width <= 0 ||  height <= 0) {
                    Console.log("Width and height must be positive");
                    return;
                }

                shape = new Rectangle(x,y,width,height,fill);

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