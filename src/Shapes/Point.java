//Ari Bloch 328792866

package Shapes;
/**
 * this class creates a Point object.
 */
public class Point {
    private final double x;
    private final double y;
    static final double EPSILON = 1E-10;

    /**
     * this is the constructor that builds and initiates the object.
     *
     * @param x the first coordinate of the point.
     * @param y the second coordinate of the point.
     */
    // constructor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * this method checks if a point is in a line.
     * @param line the line the method is checking that the point is on.
     * @return true if point is on line, false otherwise.
     */
    public boolean isPointinLine(Line line) {
        return (Math.abs(this.distance(line.start()) + this.distance(line.end())
                - line.start().distance(line.end())) < EPSILON);
    }

    /**
     * this method receives a second point in order
     * to calculate the distance between two points.
     *
     * @param other this is the other point the method receives
     * @return returns the distance found between the two points
     */
    // distance -- returns the distance of this point to the other point
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x))
                + ((this.y - other.y) * (this.y - other.y)));
    }

    /**
     * this method checks of two points are equal.
     *
     * @param other this is the other point the method receives
     * @return returns if two points are indeed equal (true) or not (false)
     */
    // equals -- return true if the points are equal, false otherwise
    //checks if the difference between the 2 points are less than epsilon
    public boolean equals(Point other) {
        return (Math.abs(this.x - other.x) <= EPSILON
                && Math.abs(this.y - other.y) <= EPSILON);
    }

    /**
     * this method returns the X coordinate of the relevant point.
     *
     * @return returns the X coordinate of the relevant point
     */
    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }

    /**
     * this method returns the Y coordinate of the relevant point.
     *
     * @return returns the Y coordinate of the relevant point
     */
    public double getY() {
        return this.y;
    }

}
