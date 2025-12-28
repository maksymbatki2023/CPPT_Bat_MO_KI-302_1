package KI302.Bat.Lab2;

/**
 * Клас, що описує серце людини.
 */
public class Heart {
    private int heartRate;

    public Heart() {
        this.heartRate = 70; // Стандартний пульс
    }

    /**
     * Змінює пульс
     * @param rate новий пульс
     */
    public void setRate(int rate) {
        this.heartRate = rate;
    }

    public int getRate() {
        return heartRate;
    }
    
    public void beat() {
        System.out.println("Серце б'ється: тук-тук.");
    }
}