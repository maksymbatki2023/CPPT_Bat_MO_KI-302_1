"""
Головний модуль програми (entry point).
Демонструє роботу з класами з пакету.
"""
import sys

# Імпортуємо класи з нашого пакету
# Структура: from <назва_папки>.<назва_файлу> import <НазваКласу>
try:
    from ki302_bat_lab9.human import Human
    from ki302_bat_lab9.student import Student
except ImportError:
    print("Помилка імпорту пакету. Переконайтеся, що ви запускаєте main.py з кореневої папки проекту.")
    sys.exit(1)

def main():
    print("--- Початок роботи програми ---")

    # 1. Створення об'єкта базового класу
    print("\n[Створення об'єкта Human]")
    person = Human("Олександр", 35)
    person.say_hello()
    person.rest()

    # 2. Створення об'єкта похідного класу
    print("\n[Створення об'єкта Student]")
    student = Student("Марія", 19, "Львівська Політехніка")
    
    # Виклик перевизначеного методу
    student.say_hello()
    
    # Виклик успадкованого методу
    student.rest()
    
    # Виклик унікального методу студента
    student.study()
    student.skip_class()

    print("\n--- Завершення роботи ---")

if __name__ == "__main__":
    main()