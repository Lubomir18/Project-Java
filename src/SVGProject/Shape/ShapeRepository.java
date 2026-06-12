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

    public String print(){
        if (shapes.isEmpty()) {
            return "No shapes available.";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < shapes.size(); i++) {

            ShapeBase shape = shapes.get(i);
            result.append(i + 1)
                    .append(". ")
                    .append(shape.getClass().getSimpleName())
                    .append(" ")
                    .append(shape.info());

            if (i < shapes.size() - 1) {
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    public String erase(int index) {

        if (index < 1 || index > shapes.size()) {
            return"There is no figure number " + index + "!";
        }

        ShapeBase removed = shapes.remove(index - 1);

        return "Erased "
                + removed.getClass().getSimpleName()
                + " (" + index + ")";
    }

    public void translateAll(double dx, double dy){
        for(ShapeBase s : shapes){
            s.translate(dx, dy);
        }
    }

    public List<ShapeBase> getAll(){
        return shapes;
    }

    public String printWithinCircle(double cx, double cy, double r){

        boolean found = false;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < shapes.size(); i++){
            ShapeBase shape = shapes.get(i);

            if(shape.isInside(cx, cy)){
                if (found) {
                    result.append(System.lineSeparator());
                }
                result.append(i + 1).append(" ").append(shape.info());
                found = true;
            }
        }

        if(!found){
            return "No figures are located within circle";
        }
        return result.toString();
    }

    public String printWithinRectangle(double x, double y, double width, double height){
        boolean found = false;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < shapes.size(); i++){
            ShapeBase shape = shapes.get(i);

            if(shape.isWithinRectangle(x, y, width, height)){
                if (found) {
                    result.append(System.lineSeparator());
                }
                result.append(i + 1).append(" ").append(shape.info());
                found = true;
            }
        }

        if(!found){
            return "No figures are located within rectangle";
        }
        return result.toString();
    }

}
