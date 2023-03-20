//Ari Bloch 328792866

package Sprite;

import biuoop.DrawSurface;
import java.util.ArrayList;

/**
 * this class is in charge of holding a collection of sprite objects.
 */
public class SpriteCollection {
    private ArrayList<Sprite> spriteList;

    //constuctor

    /**
     * this is the constructor that creates and initiates the SpriteCollection
     * object by creating a new arraylist.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * this method adds a sprite to the spriteCollection object.
     * @param s the sprite being added.
     */
    public void addSprite(Sprite s) {
        spriteList.add(s);
    }


    /**
     * this method removes a sprite from the spriteCollection object.
     * @param s the sprite being removed.
     */
    public void deleteSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    // call timePassed() on all sprites.

    /**
     * this method activates the timePassed method for all sprites.
     */
    public void notifyAllTimePassed() {
        ArrayList<Sprite> spriteList2 = new ArrayList<Sprite>(spriteList);
        for (Sprite sprite : spriteList2) {
            sprite.timePassed();
        }
    }


    /**
     * this method activates the DrawOn method for all sprites.
     *
     * @param d the surface that the sprites will be drawn on
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : spriteList) {
            sprite.drawOn(d);
        }
    }
}