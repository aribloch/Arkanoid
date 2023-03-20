//Ari Bloch 328792866

package Shapes;

import Collidables.CollisionInfo;
import Game.GameLevel;
import Game.GameEnvironment;
import biuoop.DrawSurface;
import java.awt.Color;
import Game.Velocity;


/**
 * this class creates a ball which has a center point,
 * radius, color and is also able to have velocity and
 * borders.
 */
public class Ball implements Sprite.Sprite {
    private Point center;
    private final int r;
    private final Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;
    //private BallFrame borders;
    static final double EPSILON = 1E-10;

    /**
     * this is the constructor which builds and
     * initiates the ball object.
     *
     * @param center the center point of the ball
     * @param r      the radius which determines the size of the ball
     * @param color  the color of the ball
     */
    // constructor
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;

        // default velocity is 0 unless initialized in setVelocity method
        this.velocity = new Velocity(0, 0);
    }

    /**
     * this method apllies the given game environment to the ball.
     * @param g the game envionment object
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }

    /**
     * another constructor that also builds and
     * initiates the ball object.
     *
     * @param x     the x coordinate of the center point of the ball
     * @param y     the y coordinate of the center point of the ball
     * @param r     the radius which determines the size of the ball
     * @param color the color of the ball
     */
    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color);
    }

    // accessors

    /**
     * this method returns the x coordinate of the center of the ball.
     *
     * @return the x coordinate of the center of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * this method returns the y coordinate of the center of the ball.
     *
     * @return the y coordinate of the center of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * this method returns the size (radius) of the ball.
     *
     * @return the x coordinate of the center of the ball.
     */
    public int getSize() {
        return r;
    }

    /**
     * this method returns the color of the ball.
     *
     * @return the color of the ball.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * this method draws the ball object in a drawing surface.
     *
     * @param surface the surface that the ball is being drawn on
     */
    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    //public void setBorders(Point left, Point right) {
    //    this.borders = new BallFrame(left, right);
    //}

    /**
     * this method receives a velocity object and applies it to
     * the ball.
     *
     * @param v the velocity object this method receives
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * this method receives two numbers and applies them
     * to the ball's velocity.
     *
     * @param dx the number which specifies the change
     *           of position of the X axis.
     * @param dy the number which specifies the change
     *           of position of the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * this method returns the velocity of the ball.
     *
     * @return returns the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * this method adds the ball to the game.
     * @param g the game the ball is being added to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * this method removes a ball from the game after hitting the death region.
     *
     * @param game the game the ball is being removed from
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }

    /**
     * this method moves the ball one step every time it is
     * called, and also checks as well that the ball hasn't gone
     * out of its borders and that it didn't hit the wall.
     */
    public void moveOneStep() {
        Line line = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(line);
        Point closestPoint = null;
        if (collisionInfo != null) {
            closestPoint = this.gameEnvironment.getClosestCollision(line).getcollisionPoint();
        }

        if (this.gameEnvironment.getClosestCollision(line) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
        } else if (collisionInfo != null) {
            double x = (closestPoint.getX() - center.getX()) - Math.signum(closestPoint.getX() - center.getX());
            double y = (closestPoint.getY() - center.getY()) - Math.signum(closestPoint.getY() - center.getY());
            this.center = new Velocity(x, y).applyToPoint(this.center);
            this.velocity = collisionInfo.getcollisionObject().hit(this, collisionInfo
                    .getcollisionPoint(), this.velocity);
        }
        // moves ball back into the screen if needed
        if (this.center.getX() >= 790) {
            this.center = new Point(789, this.center.getY());
            this.velocity = new Velocity(-1 * this.velocity.getDx(), this.velocity.getDy());
        }
        if (this.center.getX() <= 10) {
            this.center = new Point(11, this.center.getY());
            this.velocity = new Velocity(-1 * this.velocity.getDx(), this.velocity.getDy());
        }
        if (this.center.getY() <= 10) {
            this.center = new Point(this.center.getX(), 11);
            this.velocity = new Velocity(this.velocity.getDx(), -1 * this.velocity.getDy());
        }
        //checks if ball hits bottom of screen
//        if (this.center.getY() >= 590) {
//            this.center = new Point(this.center.getX(), 589);
//            this.velocity = new Game.Velocity(this.velocity.getDx(), -1 * this.velocity.getDy());
//        }

        //checks if ball is in the paddle
        if (this.center.getY() > 560 && collisionInfo != null) {
            if (this.center.getX() > collisionInfo.getcollisionObject()
                    .getCollisionRectangle().getUpperLeft().getX() && this.center.getX()
                    < collisionInfo.getcollisionObject()
                    .getCollisionRectangle().getUpperLeft().getX()
                    + collisionInfo.getcollisionObject().getCollisionRectangle().getWidth()) {
                this.center = new Point(this.center.getX(), 559);
            }
        }
    }
}

