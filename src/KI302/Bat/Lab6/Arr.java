package KI302.Bat.Lab6;

import java.util.ArrayList;

/**
 * Параметризований клас Arr (Масив).
 * Реалізує зберігання та обробку даних довільного типу.
 * Тип даних T повинен реалізовувати інтерфейс Comparable.
 * * @author Ваше Прізвище
 * @version 1.0
 * @param <T> тип даних, що зберігаються (має бути порівнюваним)
 */
public class Arr<T extends Comparable<T>> {
    
    // Внутрішнє сховище даних
    private ArrayList<T> arr;

    /**
     * Конструктор без параметрів.
     */
    public Arr() {
        arr = new ArrayList<T>();
    }

    /**
     * Метод додавання елемента в кінець масиву.
     * @param data елемент для додавання
     */
    public void add(T data) {
        arr.add(data);
        System.out.println("Елемент додано: " + data);
    }

    /**
     * Метод видалення елемента за індексом.
     * @param index індекс елемента
     */
    public void remove(int index) {
        if (index >= 0 && index < arr.size()) {
            T removed = arr.remove(index);
            System.out.println("Елемент видалено: " + removed);
        } else {
            System.out.println("Помилка: Невірний індекс.");
        }
    }

    /**
     * Отримати елемент за індексом.
     * @param index індекс
     * @return елемент масиву
     */
    public T get(int index) {
        return arr.get(index);
    }

    /**
     * Знайти мінімальний елемент у масиві.
     * @return мінімальний елемент або null, якщо масив порожній
     */
    public T findMin() {
        if (arr.isEmpty()) {
            return null;
        }
        
        T min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            // compareTo повертає від'ємне число, якщо поточний елемент менший за min
            if (arr.get(i).compareTo(min) < 0) {
                min = arr.get(i);
            }
        }
        return min;
    }
    
    /**
     * Вивести всі елементи на екран.
     */
    public void printAll() {
        System.out.print("Вміст масиву: ");
        for (T element : arr) {
            System.out.print(element + " | ");
        }
        System.out.println();
    }
    
    /**
     * Отримати розмір масиву.
     * @return кількість елементів
     */
    public int size() {
        return arr.size();
    }
}