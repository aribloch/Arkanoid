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
 * this class is in charge of holding the information for the second level.
 */
public class LevelTwo implements LevelInformation {
    static final double PADDLESHIFT = 10;
    static final double PADDLEWIDTH = 500;

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> ballVelocities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(216 + (12 * i), -4);
            ballVelocities.add(newVelocity);
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
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.LIGHT_GRAY);
                d.fillRectangle(0, 0, 800, 600);
                d.setColor(Color.BLUE);
                d.fillRectangle(25, 80, 750, 70);
                d.fillRectangle(25, 500, 750, 70);
                d.drawLine(400, 170, 200, 450);
                d.drawLine(400, 170, 600, 450);
                d.drawLine(200, 450, 600, 450);
                d.drawLine(200, 205, 600, 205);
                d.drawLine(200, 205, 400, 485);
                d.drawLine(600, 205, 400, 485);
            }

            @Override
            public void timePassed() {

            }
        };
        //return new Block(new Rectangle(new Point(0, 0), 800, 600), Color.LIGHT_GRAY);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        List<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.PINK);
        colors.add(Color.CYAN);

        int j = 0;
        int flag = 0;
        for (int i = 0; i < 15; i++) {
            Block newBlock = new Block(new Rectangle(
                    new Point(25 + (50 * i), 230), 50, 25), colors.get(j / 2));
            blocks.add(newBlock);
            if (j == 6 && flag == 0) {
                j--;
                flag = 1;
            }
            j++;
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
