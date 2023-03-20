package Game;

import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Sprite.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class is in charge of holding the information regarding the fourth level of the game.
 */
public class LevelFour implements LevelInformation {
    static final double PADDLESHIFT = 10;
    static final double PADDLEWIDTH = 80;

    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
//        List<Velocity> ballVelocities = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            Velocity newVelocity = Velocity.fromAngleAndSpeed(216 + (12 * i), -4);
//            ballVelocities.add(newVelocity);
//        }
//        return ballVelocities;
        List<Velocity> ballVelocities = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Velocity newVelocity = Velocity.fromAngleAndSpeed(240 + (30 * i), -4);
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 0), 800, 600), new Color(0, 128, 255));
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        List<Color> colors = new ArrayList<>();
        colors.add(Color.CYAN);
        colors.add(Color.PINK);
        colors.add(Color.WHITE);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GRAY);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 15; j++) {
                Block newBlock = new Block(new Rectangle(new Point(725 - (50 * j), 250 - (25 * i)),
                        50, 25), colors.get(i));
                blocks.add(newBlock);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks().size();
    }
}
