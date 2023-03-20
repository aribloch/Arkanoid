//Ari Bloch 328792866

package notifiers;

import Game.Counter;
import Game.GameLevel;
import Shapes.Ball;
import Shapes.Block;

/**
 * this class is in charge of updating remaining number of balls and removing them if
 * necessary.
 */
public class BallRemover implements HitListener {

    private GameLevel game;
    private Counter remainingBalls;

    /**
     * this is the constructor that creates and initiates this object.
     * @param game the game the ballRemover is part of
     * @param remainingBalls the amount of balls remaining in the game.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    // Balls that hit the death region should be removed
    // from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
