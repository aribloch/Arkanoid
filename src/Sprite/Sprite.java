//Ari Bloch 328792866

package Sprite;
import biuoop.DrawSurface;

/**
 * this interface has all the methods that need to be implemented by any sprite class.
 */
public interface Sprite {
    // draw the sprite to the screen

    /**
     * this method all sprite objects need to implement, it gives the sprite object
     * the ability to draw itself.
     *
     * @param d the surface the sprite is being drawn on
     */
    void drawOn(DrawSurface d);

    /**
     * this function notifies the sprite that time has passed.
     */
    void timePassed();
}