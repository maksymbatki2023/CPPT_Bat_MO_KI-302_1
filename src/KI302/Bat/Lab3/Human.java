package KI302.Bat.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Абстрактний клас Human реалізує сутність "Людина".
 * Є базовим класом для створення конкретних типів людей (наприклад, Спортсмен).
 * @author Ваше Прізвище
 * @version 1.0
 */
public abstract class Human {
    
    // Поля (композиція - перенесіть ці класи з Lab2 у пакет Lab3)
    protected Brain brain;
    protected Heart heart;
    protected Voice voice;
    
    protected String name;
    protected int age;
    protected PrintWriter fout;

    /**
     * Конструктор.
     * @param name Ім'я
     * @param age Вік
     * @throws FileNotFoundException помилка файлу
     */
    public Human(String name, int age) throws FileNotFoundException {
        this.name = name;
        this.age = age;
        this.brain = new Brain(100);
        this.heart = new Heart();
        this.voice = new Voice(false);
        
        fout = new PrintWriter(new File("Lab3_Log.txt"));
        log("Створено людину (абстрактну): " + name);
    }

    /**
     * Абстрактний метод: повертає рід діяльності людини.
     * Має бути реалізований у класах-нащадках.
     * @return рід діяльності
     */
    public abstract String getOccupation();

    // Загальні методи
    public void sayHello() {
        voice.say("Привіт, я " + name);
        log("Людина привіталася.");
    }
    
    public void dispose() {
        log("Завершення роботи.");
        fout.flush();
        fout.close();
    }
    
    /**
     * Метод для запису в лог.
     * @param msg повідомлення
     */
    protected void log(String msg) {
        fout.println(java.time.LocalDateTime.now() + " | " + msg);
        fout.flush();
    }
    
    // Гетери для доступу з нащадків, якщо потрібно
    public int getAge() { return age; }
}