//Ari Bloch 328792866

package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is in charge of the "PauseScreen" object used when the played wants to
 * pause the game.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * this is the constructor that creates and initiates the object.
     *
     * @param k the keyboard sensor so the object knows when to stop.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * this method draws on the drawing surface what should be displayed
     * for one specific frame of animation.
     *
     * @param d the drawing surface being drawed on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * this method is in charge of letting the animationrunner know when to stop the
     * animation.
     *
     * @return a boolean value
     */
    public boolean shouldStop() {
        return this.stop;
    }
}