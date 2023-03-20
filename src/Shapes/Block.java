//Ari Bloch 328792866

package Shapes;

import Collidables.Collidable;
import Game.GameLevel;
import notifiers.HitListener;
import notifiers.HitNotifier;
import biuoop.DrawSurface;
import Sprite.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Game.Velocity;

/**
 * this class is in charge of creating and initiating block objects
 * and their relevant methods.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners;
    private final Rectangle rect;
    private final Color color;

    //constructor

    /**
     * this is the constructor that creates and initiates a block object.
     *
     * @param rect  the rectangular shape of the block.
     * @param color the color of the block
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * this method returns the color of the block.
     *
     * @return the color of the block
     */
    public Color getColor() {
        return this.color;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (this.rect.pointLeftLine(collisionPoint) || this.rect.pointRightLine(collisionPoint)) {
            this.notifyHit(hitter);
            return new Velocity((-1 * currentVelocity.getDx()), currentVelocity.getDy());
        } else {
            this.notifyHit(hitter);
            return new Velocity((currentVelocity.getDx()), (-1 * currentVelocity.getDy()));
        }
    }

    /**
     * this method allows the block object to draw itself on a given surface.
     *
     * @param surface the surface the ball will draw itself on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(), (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
    }

    @Override
    public void timePassed() {
    }


    /**
     * this method allows the block to add itself to a given game.
     *
     * @param g the game the block will add itself to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**
     * this method removes a block from the game after being hit.
     *
     * @param game the game the block is being removed from
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * this block notifies if the specific block has been hit.
     * @param hitter the object hitting the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
