//Ari Bloch 328792866

package notifiers;


/**
 * this class is in charge of notifying when object is being hit.
 */
public interface HitNotifier {

    /**
     * this method adds hl as a listener to hit events.
     *
     * @param hl the hl being added
     */
    void addHitListener(HitListener hl);
    // Remove hl from the list of listeners to hit events.

    /**
     * this method removes hl as a listener to hit events.
     *
     * @param hl the hl being removed.
     */
    void removeHitListener(HitListener hl);
}
