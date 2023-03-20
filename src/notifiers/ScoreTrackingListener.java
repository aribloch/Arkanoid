//Ari Bloch 328792866

package notifiers;

import Game.Counter;
import Shapes.Ball;
import Shapes.Block;

/**
 * this class updates the score when relevant.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * this is the constructor that initiates the object.
     *
     * @param scoreCounter the inititial value of the current score when being created.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * @param beingHit the object being hit
     * @param hitter   the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}