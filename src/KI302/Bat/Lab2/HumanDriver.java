package KI302.Bat.Lab2;

import java.io.FileNotFoundException;

/**
 * Клас-драйвер для тестування класу Human.
 */
public class HumanDriver {

    public static void main(String[] args) {
        Human person = null;
        try {
            // Створення об'єкта
            person = new Human("Максим", 20);

            // Демонстрація методів
            person.sayHello();
            
            person.checkHealth();
            
            person.run(); // Пульс зросте
            
            person.solveProblem();
            
            person.rest(); // Пульс впаде
            
            person.haveBirthday();
            
            person.setVoiceVolume(true);
            person.sayHello(); // Тепер буде кричати

        } catch (FileNotFoundException e) {
            System.out.println("Помилка створення файлу логу: " + e.getMessage());
        } finally {
            // Коректне завершення роботи
            if (person != null) {
                person.dispose();
            }
        }
    }
}