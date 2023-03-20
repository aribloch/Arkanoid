//Ari Bloch 328792866

package Game;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Sprite.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is in charge of holding the information for the first level.
 */

public class LevelOne implements LevelInformation {
    static final double PADDLESHIFT = 10;
    static final double PADDLEWIDTH = 80;

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocities = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ballVelocities.add(new Velocity(0, -3));
        }
        return ballVelocities;
    }

    @Override
    public int paddleSpeed() {
        return (int) PADDLESHIFT;
    }

    @Override
    public int paddleWidth() {
        return (int) PADDLEWIDTH;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.BLACK);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.drawCircle(405, 170, 40);
                d.drawCircle(405, 170, 65);
                d.drawCircle(405, 170, 90);
                d.drawLine(405, 55, 405, 285);
                d.drawLine(290, 170, 520, 170);
            }

            @Override
            public void timePassed() {

            }

            //  return new Block(new Rectangle(new Point(0, 0), 800, 600), Color.BLACK);
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(new Rectangle(new Point(390, 155), 30, 30), Color.RED));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
