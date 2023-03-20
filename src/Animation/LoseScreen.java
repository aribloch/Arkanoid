//Ari Bloch 328792866

package Animation;

import Game.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * this class is in charge of the LoseScreen object, used when the player loses the game.
 */
public class LoseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * this is the constructor that creates and initiates the object.
     * @param k the keyboard sensor so the object knows when to stop.
     * @param score the score the object presents.
     */
    public LoseScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.RED);
        d.drawText(50, d.getHeight() / 2, "Game Over. Your score is "
                + this.score.getValue(), 32);

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
