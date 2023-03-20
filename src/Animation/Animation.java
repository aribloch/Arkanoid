//Ari Bloch 328792866

package Animation;

import biuoop.DrawSurface;

/**
 * this interface holds all the relevant methods for "Animation" classes.
 */
public interface Animation {
    /**
     * this method draws on the drawing surface what should be displayed
     * for one specific frame of animation.
     *
     * @param d the drawing surface being drawed on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method is in charge of letting the animationrunner know when to stop the
     * animation.
     *
     * @return a boolean value
     */
    boolean shouldStop();
}
