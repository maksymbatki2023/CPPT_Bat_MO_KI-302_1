import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Клас для виконання лабораторної роботи №1.
 * Генерує зубчатий масив, що представляє ВЕРХНІЙ трикутник матриці.
 *
 * @author Ваше Ім'я
 * @version 1.1
 */
public class Lab1BatKI302 { // Переконайтеся, що файл називається Lab1BatKI302.java

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        File file = new File("Lab1_Output.txt");
        PrintWriter fout = new PrintWriter(file);

        System.out.println("Лабораторна робота №1. Зубчаті масиви (Верхній трикутник).");
        
        // 1. Введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці (кількість рядків): ");
        int nRows;
        
        if (in.hasNextInt()) {
            nRows = in.nextInt();
            in.nextLine(); // Очищення буфера
        } else {
            System.out.println("Помилка: введено не ціле число.");
            fout.close();
            in.close();
            return;
        }

        // 2. Введення символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String filler = in.nextLine();

        if (filler.length() != 1) {
            System.out.println("\nПомилка: Не введено символ або введено більше одного символу.");
            fout.close();
            in.close();
            return;
        }

        char fillChar = filler.charAt(0);

        // 3. Створення та заповнення зубчатого масиву (Верхній трикутник)
        char[][] arr = new char[nRows][];

        System.out.println("\nРезультат:");
        
        for (int i = 0; i < nRows; i++) {
            // Для верхнього трикутника кількість елементів зменшується:
            // 1-й рядок (i=0): nRows елементів
            // 2-й рядок (i=1): nRows-1 елементів
            arr[i] = new char[nRows - i];

            // Формування відступів для візуалізації верхнього трикутника
            // Кожен наступний рядок зміщується вправо
            for (int s = 0; s < i; s++) {
                System.out.print("  "); // Два пробіли, бо виводимо "символ + пробіл"
                fout.print("  ");
            }

            // Заповнення та виведення масиву
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = fillChar;
                
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();
        in.close();
        
        System.out.println("\nРоботу завершено. Результат збережено у файл 'Lab1_Output.txt'");
    }
}