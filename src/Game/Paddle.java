//Ari Bloch 328792866

package Game;

import Collidables.Collidable;
import Shapes.Ball;
import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

import Sprite.Sprite;

/**
 * this is the class in charge of creating a paddle object and holding it's relevant
 * methods.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;
    private Block paddle;
    private double width;
    private double height;
    //private double regionWidth = this.width / 5;
    private Block region1;
    private Block region2;
    private Block region3;
    private Block region4;
    private Block region5;
    static final double PADDLESHIFT = 10;


    /**
     * this is the constructor that creates and initiates the paddle object.
     *
     * @param block    the block shape that will serve as the paddles "body".
     * @param keyboard the object that controls the paddle's movement.
     */
    public Paddle(Block block, KeyboardSensor keyboard) {
        this.paddle = block;
        this.keyboard = keyboard;
        this.width = block.getCollisionRectangle().getWidth();
        this.height = block.getCollisionRectangle().getHeight();
    }

    /**
     * this method moves the paddle left.
     */
    public void moveLeft() {
        this.paddle = new Block(new Rectangle(new Point(this.paddle.getCollisionRectangle()
                .getUpperLeft().getX() - PADDLESHIFT, this.paddle.getCollisionRectangle()
                .getUpperLeft().getY()), this.paddle.getCollisionRectangle().getWidth(),
                this.paddle.getCollisionRectangle().getHeight()), this.paddle.getColor());
        if (this.paddle.getCollisionRectangle().getUpperLeft().getX() <= 25) {
            this.paddle = new Block(new Rectangle(new Point(25,
                    this.paddle.getCollisionRectangle().getUpperLeft().getY()), this.width,
                    this.height), this.paddle.getColor());
        }
    }

    /**
     * this method moves the paddle right.
     */

    public void moveRight() {
        this.paddle = new Block(new Rectangle(new Point(this.paddle.getCollisionRectangle()
                .getUpperLeft().getX() + PADDLESHIFT, this.paddle.getCollisionRectangle()
                .getUpperLeft().getY()), this.paddle.getCollisionRectangle().getWidth(),
                this.paddle.getCollisionRectangle().getHeight()), this.paddle.getColor());
        if (this.paddle.getCollisionRectangle().getUpperLeft().getX() + this.width >= 775) {
            this.paddle = new Block(new Rectangle(new Point(775 - this.width,
                    this.paddle.getCollisionRectangle().getUpperLeft().getY()), this.width,
                    this.height), this.paddle.getColor());

        }
    }

    /**
     * this method when called checks if the paddle should change it's location or not.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * this method allows the paddle to draw itself on a given surface.
     *
     * @param d the surface the sprite is being drawn on
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.paddle.getColor());
        d.fillRectangle((int) this.paddle.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.paddle.getCollisionRectangle().getUpperLeft().getY(), (int) this.paddle.
                        getCollisionRectangle().getWidth(),
                (int) this.paddle.getCollisionRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.paddle.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.paddle.getCollisionRectangle().getUpperLeft().getY(), (int) this.paddle.
                        getCollisionRectangle().getWidth(),
                (int) this.paddle.getCollisionRectangle().getHeight());
    }


    /**
     * returns the block information of the paddle.
     *
     * @return the block information of the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }

    /**
     * this method calculates what part of the paddle the ball will hit and
     * changes it's velocity accordingly.
     *
     * @param collisionPoint  point of Collision
     * @param currentVelocity current velocity of the object that is colliding
     *                        with the collidable
     * @param hitter          the ball that hits the block.
     * @return the new velocity of the ball
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.region1 = new Block(new Rectangle(paddle.getCollisionRectangle().getUpperLeft(),
                this.width / 5, this.height), this.paddle.getColor());
        this.region2 = new Block(new Rectangle(new Point(
                this.paddle.getCollisionRectangle().getUpperLeft().getX() + this.width / 5,
                this.paddle.getCollisionRectangle().getUpperLeft().getY()),
                this.width / 5, this.height), this.paddle.getColor());
        this.region3 = new Block(new Rectangle(new Point(
                this.paddle.getCollisionRectangle().getUpperLeft().getX() + 2 * this.width / 5,
                this.paddle.getCollisionRectangle().getUpperLeft().getY()),
                this.width / 5, this.height), this.paddle.getColor());
        this.region4 = new Block(new Rectangle(new Point(
                this.paddle.getCollisionRectangle().getUpperLeft().getX() + 3 * this.width / 5,
                this.paddle.getCollisionRectangle().getUpperLeft().getY()),
                this.width / 5, this.height), this.paddle.getColor());
        this.region5 = new Block(new Rectangle(new Point(
                this.paddle.getCollisionRectangle().getUpperLeft().getX() + 4 * this.width / 5,
                this.paddle.getCollisionRectangle().getUpperLeft().getY()),
                this.width / 5, this.height), this.paddle.getColor());
        if (collisionPoint.isPointinLine(region3.getCollisionRectangle().getTopLine())) {
            return new Velocity((currentVelocity.getDx()), (-1 * currentVelocity.getDy()));
        }
        if (collisionPoint.isPointinLine(region1.getCollisionRectangle().getTopLine())) {
            return new Velocity(150, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)), 1);
        }
        if (collisionPoint.isPointinLine(region2.getCollisionRectangle().getTopLine())) {
            return new Velocity(120, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)), 1);
        }
        if (collisionPoint.isPointinLine(region4.getCollisionRectangle().getTopLine())) {
            return new Velocity(60, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)), 1);
        }
        if (collisionPoint.isPointinLine(region5.getCollisionRectangle().getTopLine())) {
            return new Velocity(20, Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                    + Math.pow(currentVelocity.getDy(), 2)), 1);
        }
        if (collisionPoint.isPointinLine(region1.getCollisionRectangle().getLeftLine())) {
            return (this.paddle.hit(hitter, collisionPoint, currentVelocity));
        }
        if (collisionPoint.isPointinLine(region5.getCollisionRectangle().getRightLine())) {
            return (this.paddle.hit(hitter, collisionPoint, currentVelocity));
        } else {
            return currentVelocity;
        }
    }

    /**
     * this method adds the paddle to the game.
     *
     * @param g the game the paddle is being added to
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}