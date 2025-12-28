package KI302.Bat.Lab6;

/**
 * Клас-драйвер для тестування параметризованого класу Arr.
 * @author Ваше Прізвище
 * @version 1.0
 */
public class Lab6BatKI302 {

    public static void main(String[] args) {
        System.out.println("--- ТЕСТ 1: Робота з цілими числами (Integer) ---");
        
        // Створення параметризованого масиву для Integer
        Arr<Integer> intArr = new Arr<>();
        
        // Додавання елементів
        intArr.add(15);
        intArr.add(4); // Мінімальний
        intArr.add(42);
        intArr.add(8);
        
        intArr.printAll();
        
        // Пошук мінімуму
        Integer minInt = intArr.findMin();
        System.out.println("Мінімальне число: " + minInt);
        
        // Видалення елемента
        intArr.remove(2); // Видаляємо 42
        intArr.printAll();
        
        
        System.out.println("\n--- ТЕСТ 2: Робота з кастомним класом (Item) ---");
        
        // Створення параметризованого масиву для Item
        Arr<Item> itemArr = new Arr<>();
        
        // Додавання елементів
        itemArr.add(new Item("Ноутбук", 25000));
        itemArr.add(new Item("Мишка", 500)); // Найдешевший
        itemArr.add(new Item("Клавіатура", 1200));
        
        itemArr.printAll();
        
        // Пошук мінімуму (за ціною, згідно з compareTo в класі Item)
        Item cheapestItem = itemArr.findMin();
        System.out.println("Найдешевший товар (мінімум): " + cheapestItem);
        
        // Виймання елемента
        Item item = itemArr.get(0);
        System.out.println("Отримано перший елемент: " + item.getName());
    }
}	