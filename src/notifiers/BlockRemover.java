//Ari Bloch 328792866

package notifiers;

import Game.Counter;
import Game.GameLevel;
import Shapes.Ball;
import Shapes.Block;

/**
 * the BlockRemover class is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * this is the constructor that creates and inititiates the Blockremover object.
     *
     * @param game          the game the blockremover is part of.
     * @param removedBlocks the amount of blocks that remain.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;

    }

    /**
     * this method makes sure that the Blocks that are being hit should be removed
     * from the game. It removes this listener from the block
     * that is being removed from the game as well.
     *
     * @param beingHit the object being hit
     * @param hitter   the Ball that's doing the hitting
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);

    }
}
