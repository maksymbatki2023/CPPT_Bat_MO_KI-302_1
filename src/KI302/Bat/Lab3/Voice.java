package KI302.Bat.Lab3;

/**
 * Клас, що описує голос людини.
 */
public class Voice {
    private boolean isLoud;

    public Voice(boolean isLoud) {
        this.isLoud = isLoud;
    }

    public void say(String phrase) {
        if (isLoud) {
            System.out.println("КРИЧИТЬ: " + phrase.toUpperCase());
        } else {
            System.out.println("Каже: " + phrase);
        }
    }
}