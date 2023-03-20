//Ari Bloch 328792866

package Game;

import Animation.AnimationRunner;
import Animation.KeyPressStoppableAnimation;
import Animation.LoseScreen;
import Animation.WinScreen;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * this class is in charge of running a given number of levels in a row.
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor keyboardSensor;
    private Counter score = new Counter();
    private Counter lives = new Counter(7);

    /**
     * this is the constructor that creates and initiates the object.
     *
     * @param ar the AnimationRunner object the Gameflow will use to animate the different levels.
     * @param ks the KeyboardSensor that controls the paddle of the game.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboardSensor = ks;
        this.runner = ar;
    }

    /**
     * this method runs the different levels one after another according to the
     * list given as a [aramter to to the method.
     *
     * @param levels the list of levels given to the function.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.runner, this.keyboardSensor, this.score, this.lives);
            level.initialize();

            while (!level.shouldStop()) {
                level.run();
            }
            if (this.lives.getValue() == 0) {
                this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                        KeyboardSensor.SPACE_KEY, new LoseScreen(this.keyboardSensor, this.score)));
                break;
            }
            if (levelInfo.numberOfBlocksToRemove() == 0) {
                break;
            }
        }
        if (this.lives.getValue() != 0) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new WinScreen(this.keyboardSensor, this.score)));
        }
    }
}
