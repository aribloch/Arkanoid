//Ari Bloch 328792866

package Animation;

import Game.LevelInformation;
import Sprite.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * this class is in charge of the countdownAnimation, which will display the
 * given gameScreen, for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private double numOfSecs;
    private int countFrom;
    private int frames;
    private int originalCount;
    private boolean toStop;
    private SpriteCollection gameScreen;
    private LevelInformation levelInfo;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    /**
     * this is the constructor that creates and initiates the CountdownAnimation object.
     *
     * @param numOfSeconds the number of seconds this object will run for.
     * @param countFrom the number the countdown starts from
     * @param gameScreen the background of the game
     * @param levelInformation the relevant information regarding the current level.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen,
                              LevelInformation levelInformation) {
        this.gameScreen = gameScreen;
        this.numOfSecs = numOfSeconds;
        this.countFrom = countFrom;
        this.originalCount = countFrom;
        this.levelInfo = levelInformation;
        this.toStop = false;
        this.frames = (int) (60 * numOfSeconds);
    }

    /**
     * this method draws on the drawing surface what should be displayed
     * for one specific frame of animation.
     *
     * @param d the drawing surface being drawed on.
     */
    public void doOneFrame(DrawSurface d) {
        this.levelInfo.getBackground().drawOn(d);
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.WHITE);
        if (this.frames > 0) {
            d.drawText(400, 300, String.valueOf((this.frames / 60) + 1), 30);
        } else {
            d.drawText(375, 300, "GO!", 45);
        }
        frames--;
        if (this.frames == -60) {
            this.toStop = true;
        }
    }

    /**
     * this method is in charge of letting the animationrunner know when to stop the
     * animation.
     *
     * @return a boolean value
     */
    public boolean shouldStop() {
        return this.toStop;
    }
}