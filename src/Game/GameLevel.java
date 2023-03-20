//Ari Bloch 328792866

package Game;

import Collidables.Collidable;
import biuoop.KeyboardSensor;
import notifiers.BallRemover;
import notifiers.BlockRemover;
import notifiers.ScoreTrackingListener;
import Shapes.Ball;
import Shapes.Block;
import Shapes.Point;
import Shapes.Rectangle;
import Sprite.ScoreIndicator;
import Sprite.SpriteCollection;
import Sprite.Sprite;
import Sprite.LevelName;
import Sprite.Lives;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import Animation.KeyPressStoppableAnimation;
import Animation.Animation;
import Animation.AnimationRunner;
import Animation.PauseScreen;
import Animation.CountdownAnimation;

/**
 * this class initiates and runs the game.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running = true;
    private LevelInformation levelInfo;
    private KeyboardSensor keyboardSensor;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Paddle paddle;
    private Counter ballCounter;
    private Counter blockCounter;
    private Counter score;
    private Counter lives;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;


    //constructor

    /**
     * this is the constructor that creates and initiates the game object.
     *
     * @param keyboardSensor keyboardSensor object sent to the constructor
     * @param runner         the animationRunner object sent to the game.
     * @param levelInfo      the LevelInformation object sent to the game.
     * @param score          the score counter in order to keep updating it.
     * @param lives          the amount of lives the player has left
     */
    public GameLevel(LevelInformation levelInfo, AnimationRunner runner, KeyboardSensor keyboardSensor,
                     Counter score, Counter lives) {
        this.levelInfo = levelInfo;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.score = score;
        this.lives = lives;
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.keyboardSensor = keyboardSensor;
        this.runner = runner;
    }

    /**
     * this method adds a collidable to the game.
     *
     * @param c the collidable being added to the game
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * this method adds sprite type objects to the game.
     *
     * @param s the sprite being added to the game.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }


    /**
     * this method initiates a new game, creates the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        BlockRemover blockremover = new BlockRemover(this, this.blockCounter);
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        this.paddle = initiatePaddle();
        Block scoreBlock = new Block(new Rectangle(new Point(0, 0), WIDTH, 30),
                Color.LIGHT_GRAY);
        Block leftBorder = new Block(new Rectangle(
                new Point(0, 20), 25, HEIGHT), Color.GRAY);
        Block righBborder = new Block(new Rectangle(
                new Point(775, 20), 25, HEIGHT), Color.GRAY);
        Block topBorder = new Block(new Rectangle(
                new Point(0, 20), WIDTH, 25), Color.GRAY);
        Block deathBlock = new Block(new Rectangle(
                new Point(0, HEIGHT), WIDTH, 10), Color.BLACK);
        deathBlock.addHitListener(ballRemover);
        scoreBlock.addToGame(this);
        leftBorder.addToGame(this);
        righBborder.addToGame(this);
        topBorder.addToGame(this);
        deathBlock.addToGame(this);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        this.addSprite(scoreIndicator);
        LevelName levelName = new LevelName(this.levelInfo);
        this.addSprite(levelName);
        Lives lives = new Lives(this.lives);
        this.addSprite(lives);
        //adds balls to game
        initiateBalls();
        //adds blocks to game
        List<Block> gameBlocks = this.levelInfo.blocks();
        for (int i = 0; i < this.levelInfo.numberOfBlocksToRemove(); i++) {
            gameBlocks.get(i).addHitListener(blockremover);
            gameBlocks.get(i).addHitListener(scoreTrackingListener);
            gameBlocks.get(i).addToGame(this);
            this.blockCounter.increase(1);
        }
    }

    /**
     * this method initiates and returns the paddle being used for the current turn.
     * @return the paddle being used for the turn.
     */
    public Paddle initiatePaddle() {
        Paddle gamePaddle = new Paddle(new Block(new Rectangle(
                new Point((800 - (float) this.levelInfo.paddleWidth()) / 2, 575),
                this.levelInfo.paddleWidth(), 15), Color.ORANGE), this.keyboardSensor);
        gamePaddle.addToGame(this);
        return gamePaddle;
    }

    /**
     * this method initiaes and creates the ball for the level being played.
     */
    public void initiateBalls() {
        List<Ball> gameBalls = new ArrayList<>();
        for (int i = 0; i < this.levelInfo.numberOfBalls(); i++) {
            Ball newBall = new Ball(new Point(400, 555), 5, Color.WHITE);
            newBall.setVelocity(this.levelInfo.initialBallVelocities().get(i));
            gameBalls.add(newBall);
            newBall.addToGame(this);
            newBall.setGameEnvironment(this.environment);
            this.ballCounter.increase(1);
        }
    }

    /**
     * this method runs the game and starts the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites, this.levelInfo));
        this.runner.run(this);
    }


    /**
     * this method removes the given collidable from the game environment.
     *
     * @param c the given collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.deleteCollidable(c);
    }

    /**
     * this method removes the given sprite from the game environment.
     *
     * @param s the given sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.deleteSprite(s);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.levelInfo.getBackground().drawOn(d);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (blockCounter.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (ballCounter.getValue() == 0) {
            this.lives.decrease(1);
            if (this.lives.getValue() > 0) {
                this.removeSprite(this.paddle);
                this.removeCollidable(this.paddle);
                this.paddle = initiatePaddle();
                initiateBalls();
                this.run();
            } else {
                this.running = false;
            }
        }
        if (this.keyboardSensor.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboardSensor,
                    KeyboardSensor.SPACE_KEY, new PauseScreen(this.keyboardSensor)));
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}