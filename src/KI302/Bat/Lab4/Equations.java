package KI302.Bat.Lab4;

/**
 * Клас Equations реалізує метод обчислення y = tg(x).
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Equations {

    /**
     * Метод обчислює тангенс кута.
     * @param x кут у градусах
     * @return результат обчислення тангенса
     * @throws CalcException якщо аргумент дорівнює 90 + 180k (тангенс не існує)
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        
        rad = Math.toRadians(x);

        // Перевірка на критичні точки: 90, 270, -90 тощо.
        // tg(x) не існує, коли cos(x) = 0.
        if ((x % 180 == 90) || (x % 180 == -90)) {
            throw new CalcException("Exception reason: Illegal value of X for tangent calculation (x = " + x + ")");
        }

        try {
            y = Math.tan(rad);
            
            // Додаткова перевірка на NaN або Infinity (на всяк випадок)
            if (Double.isNaN(y) || Double.isInfinite(y)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            // Створення виключення вищого рівня
            throw new CalcException("Unknown reason of the exception during tangent calculation");
        }
        
        return y;
    }
}