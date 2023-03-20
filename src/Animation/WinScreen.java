//Ari Bloch 328792866

package Animation;

import Game.Counter;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * this class is in charge of the WinScreen object, used when the player wins the game.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    private int counter = 0;

    /**
     * this is the constructor that creates and initiates the object.
     * @param k the keyboard sensor so the object knows when to stop.
     * @param score the score the object presents.
     */
    public WinScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (counter == 60) {
            counter = 0;
        }
        if (counter <= 30) {
            d.setColor(Color.GREEN);
        } else {
            d.setColor(Color.BLACK);
        }
        d.drawText(50, 200, "You Win!", 70);
        d.drawText(50, 280, "Your score is " + this.score.getValue(), 70);
        counter++;
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
