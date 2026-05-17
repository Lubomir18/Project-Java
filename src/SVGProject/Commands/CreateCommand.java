package SVGProject.Commands;

import SVGProject.CommandProcess.Command;
import SVGProject.Shape.Circle;
import SVGProject.Shape.Rectangle;
import SVGProject.Shape.ShapeRepository;

public class CreateCommand implements Command {

    private ShapeRepository shapeRepository;

    public CreateCommand(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

    @Override
    public void execute(String[] args) {
        try{
            if(args[1].equals("circle")){
                shapeRepository.add(new Circle(
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4])
                ));
            }
            else if(args[1].equals("rectangle")){
                shapeRepository.add(new Rectangle(
                        Double.parseDouble(args[2]),
                        Double.parseDouble(args[3]),
                        Double.parseDouble(args[4]),
                        Double.parseDouble(args[5])
                ));
            }
//            else if(args[1].equals("line")){
//                shapeRepository.add(new Line(
//                        Double.parseDouble(args[2]),
//                        Double.parseDouble(args[3]),
//                        Double.parseDouble(args[4]),
//                        Double.parseDouble(args[5])
//                ));
//            }
            Console.log("Created " + shapeRepository);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error Creating Shape");
        }
    }
}