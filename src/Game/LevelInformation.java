//Ari Bloch 328792866

package Game;

import Shapes.Block;
import Sprite.Sprite;

import java.util.List;

/**
 * this interface holds methods with all the relevant information for each level.
 */
public interface LevelInformation {
    /**
     * this method returns the number of balls the level starts with.
     *
     * @return the number of balls
     */
    int numberOfBalls();

    /**
     * this method returns a list with all the velocities of each ball.
     *
     * @return a list of velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * this method returns the paddle's speed.
     *
     * @return the paddle's speed
     */
    int paddleSpeed();

    /**
     * this method returns the paddle's width.
     *
     * @return the paddle's width
     */
    int paddleWidth();

    /**
     * this method returns the level's name that will be displayed at the top of the screen.
     *
     * @return the level's name
     */
    String levelName();

    /**
     * this method returns a sprite with the background of the level.
     * @return the bakground of the level.
     */
    Sprite getBackground();


    /**
     * this method holds of list of the blocks that make up this level, each block contains
     * its size, color and location.
     *
     * @return list of blocks
     */
    List<Block> blocks();


    /**
     * this method returns the  number of blocks that should be removed
     * before the level is considered to be "cleared".
     *
     * @return number of blocks left
     */
    int numberOfBlocksToRemove();
}