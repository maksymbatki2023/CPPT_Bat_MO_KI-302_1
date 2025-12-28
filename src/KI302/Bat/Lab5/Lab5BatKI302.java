package KI302.Bat.Lab5;

import java.io.*;
import java.util.Scanner;

/**
 * Клас-драйвер для тестування файлового вводу/виводу.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Lab5BatKI302 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Equations eq = new Equations();
        
        System.out.println("Лабораторна робота №5. Робота з файлами.");
        
        try {
            // 1. Введення даних та обчислення
            System.out.print("Введіть кут X: ");
            int x = in.nextInt();
            
            double res = eq.calculate(x);
            System.out.println("Обчислений результат: " + res);
            
            // 2. Робота з текстовим файлом
            System.out.println("\n--- Текстовий файл ---");
            eq.writeResTxt("Lab5_Res.txt");
            System.out.println("Результат записано у 'Lab5_Res.txt'.");
            
            eq.readResTxt("Lab5_Res.txt");
            System.out.println("Результат зчитано з файлу: " + eq.getResult());

            // 3. Робота з двійковим файлом
            System.out.println("\n--- Двійковий файл ---");
            eq.writeResBin("Lab5_Res.bin");
            System.out.println("Результат записано у 'Lab5_Res.bin'.");
            
            // Змінюємо результат в пам'яті, щоб перевірити зчитування
            eq.calculate(0); 
            System.out.println("Результат скинуто (для перевірки): " + eq.getResult());
            
            eq.readResBin("Lab5_Res.bin");
            System.out.println("Результат зчитано з бінарного файлу: " + eq.getResult());

        } catch (CalcException e) {
            System.out.println("Математична помилка: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка вводу/виводу: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}