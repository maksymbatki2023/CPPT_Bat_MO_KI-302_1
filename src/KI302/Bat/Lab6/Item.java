package KI302.Bat.Lab6;

/**
 * Клас Item (Товар) для тестування параметризованого класу.
 * Реалізує інтерфейс Comparable для порівняння за ціною (вартістю).
 */
public class Item implements Comparable<Item> {
    private String name;
    private int value;

    /**
     * Конструктор.
     * @param name Назва товару
     * @param value Вартість
     */
    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    /**
     * Реалізація методу порівняння.
     * Потрібна для пошуку мінімуму в класі Arr.
     */
    @Override
    public int compareTo(Item other) {
        // Порівнюємо товари за їх вартістю
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return name + "(" + value + ")";
    }
}