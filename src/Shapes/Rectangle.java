//Ari Bloch 328792866

package Shapes;
import java.util.ArrayList;

/**
 * this class is in charge of the Rectangle objects.
 */
public class Rectangle {
    private final Point upperleft;
    private final double width;
    private final double height;
    private final Line rightLine;
    private final Line leftLine;
    private final Line topLine;
    private final Line bottomLine;
    static final double EPSILON = 1E-10;

    //constructor
    // Create a new rectangle with location and width/height.

    /**
     * this is the constructor that creates and initiates a Rectangle.
     *
     * @param upperLeft the upper Left corner of the rectangle
     * @param width     the width of the rectangle
     * @param height    the height of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperleft = upperLeft;
        this.width = width;
        this.height = height;
        this.rightLine = new Line(this.upperleft.getX() + this.width, this.upperleft.getY(),
                this.upperleft.getX() + this.width, this.upperleft.getY() + this.height);
        this.leftLine = new Line(this.upperleft,
                new Point(this.upperleft.getX(), this.upperleft.getY() + this.height));
        this.topLine = new Line(this.upperleft,
                new Point(this.upperleft.getX() + this.width, this.upperleft.getY()));
        this.bottomLine = new Line(this.upperleft.getX(), this.upperleft.getY() + this.height,
                this.upperleft.getX() + this.width, this.upperleft.getY() + this.height);
    }


    // Return a (possibly empty) List of intersection points
    // with the specified line.

    /**
     * this method returns a list of intersection points of a line with a rectangle.
     *
     * @param line the line intersecting the rectangle
     * @return list of intersection points of a line with a rectangle
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        ArrayList<Point> intersectionlist = new ArrayList<>();
        Line[] lineList = new Line[4];
        lineList[0] = this.leftLine;
        lineList[1] = this.rightLine;
        lineList[2] = this.topLine;
        lineList[3] = this.bottomLine;
        for (int i = 0; i < 4; i++) {
            if (line.isIntersecting(lineList[i])
                    && line.intersectionWith(lineList[i]) != null) {
                intersectionlist.add(line.intersectionWith(lineList[i]));
            }
        }
        return intersectionlist;
    }

    //checks if Point is on left line of Rectangle

    /**
     * this method checks if a point is on the left line of a rectangle.
     * @param point point being checked
     * @return true if point is on line, false otherwise
     */
    public boolean pointLeftLine(Point point) {
        return (point.isPointinLine(this.leftLine));
    }

    //checks if Point is on right line of Rectangle
    /**
     * this method checks if a point is on the right line of a rectangle.
     * @param point point being checked
     * @return true if point is on line, false otherwise
     */
    public boolean pointRightLine(Point point) {
        return (point.isPointinLine(this.rightLine));
    }

    //checks if Point is on top line of Rectangle
    /**
     * this method checks if a point is on the top line of a rectangle.
     * @param point point being checked
     * @return true if point is on line, false otherwise
     */
    public boolean pointTopLine(Point point) {
        return (point.isPointinLine(this.topLine));
    }

    //checks if Point is bottom line of Rectangle
    /**
     * this method checks if a point is on the bottom line of a rectangle.
     * @param point point being checked
     * @return true if point is on line, false otherwise
     */
    public boolean pointBottomLine(Point point) {
        return (point.isPointinLine(this.bottomLine));
    }

    // Return the width and height of the rectangle

    /**
     * returns width of rectangle.
     * @return width of rectangle
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * returns height of rectangle.
     * @return height of rectangle
     */
    public double getHeight() {
        return this.height;
    }

    // Returns the upper-left point of the rectangle.
    /**
     * returns upper left corner of rectangle.
     * @return upper left corner of rectangle
     */
    public Point getUpperLeft() {
        return upperleft;
    }

    //Returns the right line of the rectangle
    /**
     * returns right line of rectangle.
     * @return right line of rectangle
     */
    public Line getRightLine() {
        return this.rightLine;
    }

    //Returns the left line of the rectangle
    /**
     * returns left line of rectangle.
     * @return left line of rectangle
     */
    public Line getLeftLine() {
        return this.leftLine;
    }

    //Returns the top line of the rectangle
    /**
     * returns top line of rectangle.
     * @return top line of rectangle
     */
    public Line getTopLine() {
        return this.topLine;
    }

    //Returns the bottom line of the rectangle
    /**
     * returns bottom line of rectangle.
     * @return bottom line of rectangle
     */
    public Line getBottomLine() {
        return this.bottomLine;
    }
}