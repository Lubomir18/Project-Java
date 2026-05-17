package SVGProject.Shape;

public class Circle implements ShapeBase {

    private double cx, cy, r;

    public Circle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public void translate(double dx, double dy) {
        cx += dx;
        cy += dy;
    }

    @Override
    public boolean isInside(double x, double y) {
        double dx = cx - x;
        double dy = cy - y;
        return dx * dx + dy * dy <= r * r;
    }

    @Override
    public String toSVG() {
        return "<circle cx=\"" + cx + "\" cy=\"" + cy + "\" r=\"" + r + "\" />";
    }

    @Override
    public String info() {
        return "Circle (" + cx + ", " + cy + ") r=" + r;
    }

    @Override
    public boolean isWithinRectangle(double x, double y, double width, double height) {

        return cx - r >= x &&
                cy - r >= y &&
                cx + r <= x + width &&
                cy + r <= y + height;
    }
}
