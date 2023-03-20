//Ari Bloch 328792866

package Collidables;

import Shapes.Point;

/**
 * this class is in charge og holding the information of a potential collision.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    //constructor

    /**
     * this is the constructor that creates and initiates a CollisionInfo object.
     *
     * @param collisionPoint  the collision point
     * @param collisionObject the object the ball is colliding with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * @return returns the collision point.
     */
    // the point at which the collision occurs.
    public Point getcollisionPoint() {
        return this.collisionPoint;
    }

    /**
     * @return returns the object ball is colliding with
     */
    // the collidable object involved in the collision.
    public Collidable getcollisionObject() {
        return this.collisionObject;
    }

}