//Ari Bloch 328792866

package Sprite;

import Game.Counter;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class is in charge of showing the current score of the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * this is the constructor that initiates the scoreindicator object.
     * @param score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(380, 15, "Score:" + (this.score.getValue()), 15);
    }

    @Override
    public void timePassed() {
    }
}
