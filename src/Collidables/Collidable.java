//Ari Bloch 328792866

package Collidables;

import Game.Velocity;
import Shapes.Ball;
import Shapes.Point;
import Shapes.Rectangle;

/**
 * this interface has all the methods that need to be implemented by any collidable class.
 */
public interface Collidable {
    // Return the "collision shape" of the object.

    /**
     * this function all collidable objects need to implement, it returns the shape of the object.
     *
     * @return the rectangle shape of the collidable object
     */
    Rectangle getCollisionRectangle();

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The  (based on
    // the force the object inflicted on us).

    /**
     * this function all collidable objects need to implement and it notifies
     * the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  point of Collision
     * @param currentVelocity current velocity of the object that is colliding
     *                        with the collidable
     * @param hitter          the ball that hits the block.
     * @return return is the new velocity expected after the hit
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}