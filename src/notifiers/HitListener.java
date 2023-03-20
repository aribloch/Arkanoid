//Ari Bloch 328792866

package notifiers;

import Shapes.Ball;
import Shapes.Block;

/**
 * this interface hols the methods relevant to all classes who implement Hitlistener.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the object being hit
     * @param hitter   the Ball that's doing the hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}

