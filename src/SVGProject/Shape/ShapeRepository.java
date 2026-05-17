package SVGProject.Shape;

import SVGProject.Commands.Console;

import java.util.ArrayList;
import java.util.List;

public class ShapeRepository {

    private List<ShapeBase> shapes = new ArrayList<>();

    public void add(ShapeBase s){
        shapes.add(s);
    }

    public ShapeBase get(int index) {

        if (index < 1 || index > shapes.size()) {
            return null;
        }

        return shapes.get(index - 1);
    }

    public int size() {
        return shapes.size();
    }

    public void clear(){
        shapes.clear();
    }

    public void print(){
        if (shapes.isEmpty()) {
            Console.log("No shapes available.");
            return;
        }

        for (int i = 0; i < shapes.size(); i++) {

            ShapeBase shape = shapes.get(i);
            Console.log(
                    (i + 1) + ". "
                            + shape.getClass().getSimpleName()
                            + " "
                            + shape.info()
            );
        }
    }

    public void erase(int index) {

        if (index < 1 || index > shapes.size()) {
            Console.log("There is no figure number " + index + "!");
            return;
        }

        ShapeBase removed = shapes.remove(index - 1);

        Console.log("Erased "
                + removed.getClass().getSimpleName()
                + " (" + index + ")");
    }

    public void translateAll(double dx, double dy){
        for(ShapeBase s : shapes){
            s.translate(dx, dy);
        }
    }

    public List<ShapeBase> getAll(){
        return shapes;
    }

    public void printWithinCircle(double cx, double cy, double r){

        boolean found = false;

        for(int i = 0; i < shapes.size(); i++){
            ShapeBase shape = shapes.get(i);

            if(shape.isInside(cx, cy)){
                Console.log((i + 1) + " " +  shape.info());
                found = true;
            }
        }

        if(!found){
            Console.log("No figures are located within circle");
        }

    }

    public void printWithinRectangle(double x, double y, double width, double height){
        boolean found = false;

        for(int i = 0; i < shapes.size(); i++){
            ShapeBase shape = shapes.get(i);

            if(shape.isInside(x, y)){
                Console.log((i + 1) + " " +  shape.info());
                found = true;
            }
        }

        if(!found){
            Console.log("No figures are located within rectangle");
        }
    }

}
