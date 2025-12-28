package KI302.Bat.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас-драйвер для тестування роботи класу Sportsman.
 */
public class SportsmanApp {

    public static void main(String[] args) {
        Sportsman athlete = null;
        
        try {
            // Створення спортсмена
            athlete = new Sportsman("Максим", 23, "Футбол");

            // Виклик методів базового класу Human
            athlete.sayHello();
            
            // Виклик реалізованого абстрактного методу
            System.out.println("Діяльність: " + athlete.getOccupation());

            // Виклик власних методів
            athlete.train();
            
            // Виклик методів інтерфейсу
            athlete.compete();
            
            // Ще методи
            athlete.winMedal();
            athlete.winMedal();

        } catch (FileNotFoundException e) {
            System.out.println("Помилка при роботі з файлом: " + e.getMessage());
        } finally {
            // Коректне завершення (закриття потоку файлу)
            if (athlete != null) {
                athlete.dispose();
            }
        }
    }
}