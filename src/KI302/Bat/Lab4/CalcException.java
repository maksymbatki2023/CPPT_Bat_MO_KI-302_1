package KI302.Bat.Lab4;

/**
 * Клас CalcException реалізує власне виключення для помилок обчислення.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class CalcException extends ArithmeticException {
    
    /**
     * Конструктор без параметрів
     */
    public CalcException() {
    }

    /**
     * Конструктор з повідомленням про помилку
     * @param cause повідомлення про причину помилки
     */
    public CalcException(String cause) {
        super(cause);
    }
}