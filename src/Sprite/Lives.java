//Ari Bloch 328792866

package Sprite;

import Game.Counter;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * this class is in charge of holding the amount of lives the player has left.
 */
public class Lives implements Sprite {
    private Counter lives;

    /**
     * this is the constructor that initiates the Lives object.
     * @param lives
     */
    public Lives(Counter lives) {
        this.lives = lives;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(35, 15, "Lives:" + (this.lives.getValue()), 15);
    }

    @Override
    public void timePassed() {

    }
}
