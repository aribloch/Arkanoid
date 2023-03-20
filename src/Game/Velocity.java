//Ari Bloch 328792866
package Game;

import Shapes.Point;

/**
 * this method creates and applies method to the Game.Velocity
 * object which specifies the change in position on
 * the `x` and the `y` axes.
 */

public class Velocity {
    private final double dx;
    private final double dy;

    /**
     * this is the constructor the builds and initiates the Game.Velocity object.
     *
     * @param dx a number which specifies the change in position
     *           on the `x` axis.
     * @param dy a number which specifies the change in position
     *           on the `y` axis.
     */
    // constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * this is the constructor the builds and initiates the Game.Velocity object by receiving
     * angle and speed parameters.
     * @param angle the angle parameter.
     * @param speed the speed parameter.
     * @param i this parameter is in order that the program doesn't get confused and
     *          calls the wrong constructor so the two constructors don't have the same parameters.
     */
    public Velocity(double angle, double speed, int i) {
        this.dx = (fromAngleAndSpeed(angle, speed)).dx;
        this.dy = (fromAngleAndSpeed(angle, speed)).dy;
    }

    /**
     * this method applies the velocity to a point.
     *
     * @param p the point before velocity has been applied to it.
     * @return the new point after velocity has been applied to it.
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx,
                p.getY() + this.dy);
    }

    /**
     * this method returns the change of position on
     * the X axis of the point.
     *
     * @return the change of position on
     * the X axis of the point.
     */
    //returns dx of velocity
    public double getDx() {
        return dx;
    }

    /**
     * this method returns the change of position on
     * the Y axis of the point.
     *
     * @return the change of position on
     * the Y axis of the point.
     */
    //returns dy of velocity
    public double getDy() {
        return dy;
    }

    /**
     * this method calculates and changes the parameters of the velocity
     * from angle and speed to the value of the "change of point" on the 'x' and
     * 'y' axis.
     *
     * @param angle the angle the object id moving in.
     * @param speed the speed of the object.
     * @return the change in position of the point in 'dx', 'dy'
     * values.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(Math.toRadians(angle));
        double dy = speed * -Math.sin(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
}
