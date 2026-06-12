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
    public String execute(String[] args) {
        try{
            ShapeBase shape;

            if (args.length < 2) {
                return "Usage:" + System.lineSeparator() +
                "create circle [cx] [cy] [r] [color]" + System.lineSeparator() +
                "create rectangle [x] [y] [width] [height] [color]";

            }

            if(args[1].equalsIgnoreCase("circle")){

                if (args.length < 5) {
                    return "Usage: create circle cx cy r [color]";

                }

                String fill = "black";

                if(args.length >= 6){
                    fill = args[5];
                }

                double cx = Double.parseDouble(args[2]);
                double cy =Double.parseDouble(args[3]);
                double r =Double.parseDouble(args[4]);

                if (r <= 0) {
                    return "Radius must be positive";
                }

                shape = new Circle(cx,cy,r,fill);

            }
            else if(args[1].equalsIgnoreCase("rectangle")){

                if (args.length < 6) {
                    return "Usage: create rectangle x y width height [color]";
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
                    return "Width and height must be positive";
                }

                shape = new Rectangle(x,y,width,height,fill);

            } else {
                return "Unknown shape: " + args[1];
            }

            shapeRepository.add(shape);

            return"Created " + shape.info();
        } catch (RuntimeException e) {
            return"Error Creating Shape";
        }
    }
}