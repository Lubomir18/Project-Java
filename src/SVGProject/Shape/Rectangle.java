package SVGProject.Shape;

public class Rectangle implements ShapeBase{

    private double x, y, width, height;

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y +=dy;
    }

    @Override
    public boolean isInside(double px, double py) {
        return px >= x && px <= x + width &&
                py >= y && py <= y + height;
    }

    @Override
    public String toSVG() {
        return "<rect x=\"" + x + "\" y=\"" + y +
                "\" width=\"" + width +
                "\" height=\"" + height + "\" />";
    }

    @Override
    public String info() {
        return "Rectangle (" + x + ", " + y + ")";
    }

    @Override
    public boolean isWithinRectangle(double rx, double ry, double rWidth, double rHeight) {

        return x >= rx &&
                y >= ry &&
                x + width <= rx + rWidth &&
                y + height <= ry + rHeight;
    }
}
