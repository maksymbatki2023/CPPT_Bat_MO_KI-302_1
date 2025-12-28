"""
Модуль student.py
Містить похідний клас Student.
"""
from .human import Human

class Student(Human):
    """
    Клас Student, що успадковує Human.
    Додає специфічні поля (університет) та методи (навчання).
    """
    def __init__(self, name, age, university):
        """
        Конструктор класу Student.
        :param name: Ім'я
        :param age: Вік
        :param university: Назва університету
        """
        # Виклик конструктора батьківського класу
        super().__init__(name, age)
        self.university = university
        print(f"Student constructor: Студент зарахований до {self.university}.")

    def study(self):
        """
        Унікальний метод студента.
        """
        print(f"Студент {self.name} вивчає програмування в {self.university}.")

    def say_hello(self):
        """
        Перевизначений метод вітання (Polymorphism).
        """
        print(f"Вітаю! Я студент {self.name} з {self.university}.")
    
    def skip_class(self):
        """
        Метод прогулу пари.
        """
        print(f"{self.name} вирішив прогуляти пару і піти на каву.")