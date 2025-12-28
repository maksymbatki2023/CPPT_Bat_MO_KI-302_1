package KI302.Bat.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас Equations реалізує обчислення y = tg(x) та запис/читання результату у файл.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Equations {

    private double result; // Поле для зберігання результату

    /**
     * Метод обчислює тангенс кута.
     * @param x кут у градусах
     * @return результат обчислення
     * @throws CalcException якщо аргумент дорівнює 90 + 180k
     */
    public double calculate(int x) throws CalcException {
        double rad = Math.toRadians(x);

        if ((x % 180 == 90) || (x % 180 == -90)) {
            throw new CalcException("Exception reason: Illegal value of X for tangent calculation (x = " + x + ")");
        }

        try {
            result = Math.tan(rad);
            
            if (Double.isNaN(result) || Double.isInfinite(result)) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException ex) {
            throw new CalcException("Unknown reason of the exception during tangent calculation");
        }
        
        return result;
    }

    /**
     * Отримати поточний результат.
     * @return значення result
     */
    public double getResult() {
        return result;
    }

    /**
     * Запис результату у текстовий файл.
     * @param fName ім'я файлу
     * @throws FileNotFoundException якщо не вдалося створити файл
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ", result);
        f.close();
    }

    /**
     * Читання результату з текстового файлу.
     * @param fName ім'я файлу
     * @throws FileNotFoundException якщо файл не знайдено
     */
    public void readResTxt(String fName) throws FileNotFoundException {
        File f = new File(fName);
        if (f.exists()) {
            Scanner s = new Scanner(f);
            // Налаштування локалі, щоб зчитувати і крапку, і кому
            s.useLocale(java.util.Locale.US); 
            if (s.hasNextDouble()) {
                result = s.nextDouble();
            }
            s.close();
        } else {
            throw new FileNotFoundException("File " + fName + " not found");
        }
    }

    /**
     * Запис результату у двійковий файл.
     * @param fName ім'я файлу
     * @throws IOException при помилках вводу/виводу
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Читання результату з двійкового файлу.
     * @param fName ім'я файлу
     * @throws IOException при помилках вводу/виводу
     * @throws FileNotFoundException якщо файл не знайдено
     */
    public void readResBin(String fName) throws IOException, FileNotFoundException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
}