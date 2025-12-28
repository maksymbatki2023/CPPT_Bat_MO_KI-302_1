package KI302.Bat.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Клас Human реалізує сутність "Людина".
 * Містить поля-об'єкти (Brain, Heart, Voice) та веде лог дій у файл.
 * * @author Ваше Прізвище
 * @version 1.0
 */
public class Human {
    
    // Поля (мінімум 3 об'єкти)
    private Brain brain;
    private Heart heart;
    private Voice voice;
    
    private String name;
    private int age;
    private PrintWriter fout; // Для запису у файл

    /**
     * Конструктор без параметрів.
     * Створює людину за замовчуванням.
     * @throws FileNotFoundException якщо не вдалося створити файл логу
     */
    public Human() throws FileNotFoundException {
        this("Unknown", 18);
    }

    /**
     * Конструктор з параметрами.
     * @param name Ім'я людини
     * @param age Вік людини
     * @throws FileNotFoundException якщо не вдалося створити файл логу
     */
    public Human(String name, int age) throws FileNotFoundException {
        this.name = name;
        this.age = age;
        
        // Ініціалізація складових
        this.brain = new Brain(100);
        this.heart = new Heart();
        this.voice = new Voice(false);
        
        // Ініціалізація логування
        fout = new PrintWriter(new File("HumanLog.txt"));
        log("Створено людину: " + name + ", вік: " + age);
    }

    // --- Методи (мінімум 10) ---

    /**
     * Людина вітається.
     */
    public void sayHello() {
        voice.say("Привіт, мене звати " + name);
        log("Людина привіталася.");
    }

    /**
     * Людина біжить. Це впливає на серце.
     */
    public void run() {
        heart.setRate(120);
        log("Людина побігла. Пульс зріс до " + heart.getRate());
        System.out.println(name + " біжить...");
    }

    /**
     * Людина відпочиває. Пульс нормалізується.
     */
    public void rest() {
        heart.setRate(70);
        log("Людина відпочила. Пульс: " + heart.getRate());
        System.out.println(name + " відпочиває.");
    }

    /**
     * Людина вирішує задачу (використовує мозок).
     */
    public void solveProblem() {
        brain.think();
        log("Людина використала мозок (IQ: " + brain.getIqLevel() + ") для вирішення задачі.");
    }

    /**
     * Змінити гучність голосу.
     * @param isLoud true - кричати, false - говорити спокійно
     */
    public void setVoiceVolume(boolean isLoud) {
        this.voice = new Voice(isLoud);
        log("Змінено гучність голосу. Гучний: " + isLoud);
    }

    /**
     * Отримати вік.
     * @return вік
     */
    public int getAge() {
        log("Запитано вік: " + age);
        return age;
    }

    /**
     * Встановити нове ім'я.
     * @param newName нове ім'я
     */
    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        log("Ім'я змінено з " + oldName + " на " + newName);
    }

    /**
     * Перевірка статусу людини.
     */
    public void checkHealth() {
        log("Перевірка здоров'я. Пульс: " + heart.getRate());
        heart.beat();
    }
    
    /**
     * Метод святкування дня народження.
     */
    public void haveBirthday() {
        age++;
        log("День народження! Тепер вік: " + age);
        voice.say("Ура! Мені вже " + age);
    }

    /**
     * Коректне завершення роботи з файлом.
     * Цей метод потрібно викликати перед завершенням роботи об'єкта.
     */
    public void dispose() {
        log("Завершення роботи об'єкта Human.");
        fout.flush();
        fout.close();
        System.out.println("Лог-файл закрито.");
    }
    
    /**
     * Приватний метод для запису повідомлень у файл.
     * @param message повідомлення
     */
    private void log(String message) {
        // Записуємо час та повідомлення
        fout.println(java.time.LocalDateTime.now() + " | " + message);
        fout.flush(); // Гарантуємо запис на диск
    }
}