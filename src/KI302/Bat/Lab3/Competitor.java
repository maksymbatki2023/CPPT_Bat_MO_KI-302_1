package KI302.Bat.Lab3;

/**
 * Інтерфейс, що описує поведінку учасника змагань.
 */
public interface Competitor {
    /**
     * Метод для участі у змаганнях.
     */
    void compete();

    /**
     * Метод для отримання виду спорту.
     * @return назва виду спорту
     */
    String getSportType();
}