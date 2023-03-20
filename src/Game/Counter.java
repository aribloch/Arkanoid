//Ari Bloch 328792866

package Game;
/**
 * this class is in charge of keeping count.
 */
public class Counter {
    private int value;

    /**
     * this contructor receives a number and initiates this object using this number.
     *
     * @param value the value that the counter starts at
     */
    public Counter(int value) {
        this.value = value;
    }

    /**
     * this constructor initiates the object from zero.
     */
    public Counter() {
        this.value = 0;
    }

    /**
     * this method adds number to current count.
     *
     * @param number
     */
    public void increase(int number) {
        this.value += number;
    }

    /**
     * this method subtracts number to current count.
     *
     * @param number
     */
    public void decrease(int number) {
        this.value -= number;
    }

    /**
     * this method returns the current count.
     *
     * @return the current count
     */
    public int getValue() {
        return this.value;
    }
}