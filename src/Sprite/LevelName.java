//Ari Bloch 328792866
package Sprite;

import Game.LevelInformation;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * this class is in charge of the names of each level.
 */
public class LevelName implements Sprite {
    private LevelInformation levelInformation;

    /**
     * this is the constructor that creates and initiates the object.
     * @param levelInformation the levelinformation regarding the relevent level.
     */
    public LevelName(LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(580, 15, "Level Name:"
                + (this.levelInformation.levelName()), 15);
    }

    @Override
    public void timePassed() {

    }
}
