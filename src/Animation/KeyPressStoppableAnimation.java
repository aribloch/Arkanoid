//Ari Bloch 328792866

package Animation;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is in charge of all the animations that stop when a certain key is pressed.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * this is the constructor that creates and initiates the object.
     * @param sensor the keyboard sensor which detects if a key is pressed
     * @param key the specific key that will stop the animation
     * @param animation the animation that will be runned.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.animation = animation;
        this.keyboardSensor = sensor;
        this.key = key;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.keyboardSensor.isPressed(this.key)) {
            if (!this.isAlreadyPressed) {
                this.stop = true;
                this.isAlreadyPressed = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop || this.animation.shouldStop();
    }
}
