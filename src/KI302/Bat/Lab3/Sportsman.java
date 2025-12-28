package KI302.Bat.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас Sportsman. Розширює клас Human та реалізує інтерфейс Competitor.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Sportsman extends Human implements Competitor {

    private String sportType;
    private int medalsCount;

    /**
     * Конструктор спортсмена.
     * @param name Ім'я
     * @param age Вік
     * @param sportType Вид спорту
     * @throws FileNotFoundException помилка створення файлу
     */
    public Sportsman(String name, int age, String sportType) throws FileNotFoundException {
        // Виклик конструктора суперкласу (Human)
        super(name, age);
        this.sportType = sportType;
        this.medalsCount = 0;
        log("Створено спортсмена. Вид спорту: " + sportType);
    }

    // --- Реалізація абстрактного методу з Human ---
    @Override
    public String getOccupation() {
        return "Спортсмен (" + sportType + ")";
    }

    // --- Реалізація методів інтерфейсу Competitor ---
    @Override
    public void compete() {
        log("Спортсмен бере участь у змаганнях з " + sportType);
        System.out.println(name + " змагається!");
        
        // Вплив на складові частини (спадщина Lab2)
        heart.setRate(150); // Пульс зростає
        brain.think();      // Стратегія гри
    }

    @Override
    public String getSportType() {
        return sportType;
    }

    // --- Власні методи класу ---
    
    /**
     * Метод тренування.
     */
    public void train() {
        log("Тренування розпочато.");
        System.out.println(name + " тренується...");
        heart.setRate(130);
    }

    /**
     * Виграти медаль.
     */
    public void winMedal() {
        medalsCount++;
        log("Виграно медаль! Всього медалей: " + medalsCount);
        voice.say("Я переміг! У мене тепер " + medalsCount + " медалей!");
    }
}