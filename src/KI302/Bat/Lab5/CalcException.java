package KI302.Bat.Lab5;

/**
 * Клас CalcException реалізує власне виключення для помилок обчислення.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class CalcException extends ArithmeticException {
    public CalcException() {
    }

    public CalcException(String cause) {
        super(cause);
    }
}