"""
Модуль human.py
Містить базовий клас Human.
"""

class Human:
    """
    Базовий клас, що описує людину.
    """
    def __init__(self, name, age):
        """
        Конструктор класу Human.
        :param name: Ім'я людини
        :param age: Вік людини
        """
        self.name = name
        self.age = age
        print(f"Human constructor: Створено людину {self.name}.")

    def say_hello(self):
        """
        Метод вітання.
        """
        print(f"Привіт! Мене звати {self.name}, мені {self.age} років.")

    def rest(self):
        """
        Метод відпочинку.
        """
        print(f"{self.name} відпочиває...")

    def get_age(self):
        """
        Повертає вік.
        """
        return self.age