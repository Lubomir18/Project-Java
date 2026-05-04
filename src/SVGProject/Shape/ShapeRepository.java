package SVGProject.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeRepository {

    private List<ShapeBase> shapes = new ArrayList<>();

    public void add(ShapeBase s){
        shapes.add(s);
    }

    public void print(){
        for (int i = 0; i < shapes.size(); i++){
            System.out.println((i + 1) + ". " + shapes.get(i).info());
        }
    }

    public void erase(int index){
        if(index < 1 || index > shapes.size()){
            System.out.println("Invalid Index");
            return;
        }
        shapes.remove(index - 1);
    }

    public void translateAll(double dx, double dy){
        for(ShapeBase s : shapes){
            s.translate(dx, dy);
        }
    }

    public List<ShapeBase> getAll(){
        return shapes;
    }

}
