package SVGProject.Shape;

public interface ShapeBase {
    void translate(double dx, double dy);
    boolean isInside(double x, double y);
    boolean isWithinRectangle(double x, double y, double width, double height);
    String toSVG();
    String info();
}
