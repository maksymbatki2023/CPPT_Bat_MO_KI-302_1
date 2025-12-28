package KI302.Bat.Lab3;

/**
 * Клас, що описує мозок людини.
 */
public class Brain {
    private int iqLevel;

    /**
     * Конструктор
     * @param iq Рівень IQ
     */
    public Brain(int iq) {
        this.iqLevel = iq;
    }

    /**
     * Метод мислення
     */
    public void think() {
        System.out.println("Мозок обробляє інформацію...");
    }
    
    public int getIqLevel() {
        return iqLevel;
    }
}