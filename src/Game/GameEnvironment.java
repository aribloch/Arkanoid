//Ari Bloch 328792866

package Game;

import Collidables.Collidable;
import Collidables.CollisionInfo;
import Shapes.Line;
import Shapes.Point;

import java.util.ArrayList;

/**
 * this class is in charge of the gameenvironement object that holds a list
 * of all the collidable objects in the game.
 */
public class GameEnvironment {
    private ArrayList<Collidable> collidables;

    //constructor

    /**
     * this is the constructor that creates and initiates the GameEnvironment object
     * by creating a new list.
     */
    public GameEnvironment() {
        this.collidables = new ArrayList<>();
    }


    /**
     * this method adds the given collidable to the environment.
     *
     * @param c the given collidable being added
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * this method removes the given collidable to the environment.
     *
     * @param c the given collidable being removed
     */
    public void deleteCollidable(Collidable c) {
        this.collidables.remove(c);
    }
    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * this method checks if an object is going to collide with a collidable in it's
     * next step.
     *
     * @param trajectory the line that describes the objects next step.
     * @return A collisionInfo object that holds the information regarding
     * the next collision of the ball.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        ArrayList<Point> pointCollisionlist = new ArrayList<>();
        //creates an array of potential collision points
        for (Collidable collidable : collidables) {
            if (trajectory.closestIntersectionToStartOfLine(collidable
                    .getCollisionRectangle()) != null) {
                pointCollisionlist.add(trajectory.
                        closestIntersectionToStartOfLine(collidable.getCollisionRectangle()));
            }
        }
        //finding closest point to the start of the line
        Point closestCollisionPoint;
        if (!pointCollisionlist.isEmpty()) {
            closestCollisionPoint = pointCollisionlist.get(0);
        } else {
            return null;
        }
        for (Point point : pointCollisionlist) {
            if (trajectory.start().distance(point)
                    < trajectory.start().distance(closestCollisionPoint)) {
                closestCollisionPoint = point;
            }
        }
        //finding collision object
        Collidable collisionObject = null;
        for (Collidable collidable : collidables) {
            if (trajectory.closestIntersectionToStartOfLine(collidable
                    .getCollisionRectangle()) != null) {
                if (trajectory.closestIntersectionToStartOfLine(collidable
                        .getCollisionRectangle()).equals(closestCollisionPoint)) {
                    collisionObject = collidable;
                }

            }
        }
        return new CollisionInfo(closestCollisionPoint, collisionObject);
    }
}