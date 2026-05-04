package SVGProject.Shape;

public interface ShapeBase {
    void translate(double dx, double dy);
    boolean isInside(double x, double y);
    String toSVG();
    String info();
}
