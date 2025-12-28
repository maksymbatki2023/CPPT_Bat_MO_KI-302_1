package KI302.Bat.Lab4;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Клас-драйвер для тестування обчислення виразу y = tg(x).
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Lab4BatKI302 {

    /**
     * Головний метод програми.
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter fout = null;
        
        try {
            fout = new PrintWriter(new File("Lab4_Result.txt"));
            
            System.out.print("Введіть значення кута X (у градусах): ");
            int x = in.nextInt();
            
            // Створення об'єкта класу обчислень
            Equations eq = new Equations();
            
            // Обчислення виразу
            double result = eq.calculate(x);
            
            System.out.println("Результат: y = tg(" + x + ") = " + result);
            fout.println("Результат: y = tg(" + x + ") = " + result);
            
        } catch (CalcException ex) {
            // Обробка нашого власного виключення
            System.out.print("Помилка обчислення: " + ex.getMessage());
            if (fout != null) {
                fout.print("Помилка обчислення: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            // Обробка помилки створення файлу
            System.out.print("Помилка: Не вдалося створити файл.");
        } catch (java.util.InputMismatchException ex) {
            // Обробка введення не числа
            System.out.print("Помилка: Введено не ціле число.");
        } finally {
            // Блок finally виконується завжди для закриття ресурсів
            if (fout != null) {
                fout.flush();
                fout.close();
            }
            in.close();
            System.out.println("\nРоботу завершено.");
        }
    }
}