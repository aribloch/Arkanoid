//Ari Bloch 328792866

import Animation.AnimationRunner;
import Game.GameFlow;
import Game.LevelInformation;
import Game.LevelOne;
import Game.LevelTwo;
import Game.LevelThree;
import Game.LevelFour;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;


/**
 * this class runs the program.
 */
public class Ass6Game {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    /**
     * the main function creates a game object, initiates the game and then runs it.
     *
     * @param args none
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Gui", WIDTH, HEIGHT);
        List<LevelInformation> defaultLevels = new ArrayList<>();
        LevelInformation levelOne = new LevelOne();
        LevelInformation levelTwo = new LevelTwo();
        LevelInformation levelThree = new LevelThree();
        LevelInformation levelFour = new LevelFour();
        defaultLevels.add(levelOne);
        defaultLevels.add(levelTwo);
        defaultLevels.add(levelThree);
        defaultLevels.add(levelFour);
        GameFlow game = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor());
        List<LevelInformation> levelsToPlay = new ArrayList<>();
        for (String arg : args) {
            try {
                if (Integer.parseInt(arg) >= 1 && Integer.parseInt(arg) <= 4) {
                    if (Integer.parseInt(arg) == 1) {
                        levelsToPlay.add(levelOne);
                    }
                    if (Integer.parseInt(arg) == 2) {
                        levelsToPlay.add(levelTwo);
                    }
                    if (Integer.parseInt(arg) == 3) {
                        levelsToPlay.add(levelThree);
                    }
                    if (Integer.parseInt(arg) == 4) {
                        levelsToPlay.add(levelFour);
                    }
                }
            } catch (Exception exception) {

            }
        }
        if (levelsToPlay.size() == 0) {
            game.runLevels(defaultLevels);
        } else {
            game.runLevels(levelsToPlay);
        }
        gui.close();
    }
}
