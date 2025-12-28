import math
import struct
import sys
import os

"""
    Модуль для виконання лабораторної роботи №8.
    Реалізує обчислення виразу y = tg(x) та роботу з файлами.
"""

def calculate(x_deg):
    """
    Обчислює y = tg(x).
    
    :param x_deg: кут у градусах
    :return: результат тангенса
    :raises ValueError: якщо тангенс не існує (90, 270 градусів...)
    """
    # Перевірка на критичні точки (90 + 180*k)
    # Через особливості float порівнюємо з невеликою похибкою або точно перевіряємо цілі
    if (x_deg - 90) % 180 == 0:
        raise ValueError(f"Тангенс не існує для кута {x_deg} градусів.")
    
    # Переведення градусів у радіани
    rad = math.radians(x_deg)
    return math.tan(rad)

def write_res_txt(f_name, result):
    """
    Засує результат у текстовий файл.
    
    :param f_name: ім'я файлу
    :param result: числове значення
    """
    try:
        with open(f_name, 'w') as f:
            f.write(str(result))
    except IOError as e:
        print(f"Помилка запису у текстовий файл: {e}")
        sys.exit(1)

def read_res_txt(f_name):
    """
    Зчитує результат з текстового файлу.
    
    :param f_name: ім'я файлу
    :return: зчитане числове значення
    """
    result = 0.0
    try:
        if os.path.exists(f_name):
            with open(f_name, 'r') as f:
                result = float(f.read())
        else:
            raise FileNotFoundError(f"Файл {f_name} не знайдено.")
    except (FileNotFoundError, ValueError) as e:
        print(f"Помилка читання з текстового файлу: {e}")
        sys.exit(1)
    return result

def write_res_bin(f_name, result):
    """
    Записує результат у двійковий файл.
    
    :param f_name: ім'я файлу
    :param result: числове значення
    """
    try:
        with open(f_name, 'wb') as f:
            # 'd' означає double (8 байт float)
            # pack перетворює Python float у байти
            packed_data = struct.pack('d', result)
            f.write(packed_data)
    except IOError as e:
        print(f"Помилка запису у двійковий файл: {e}")
        sys.exit(1)

def read_res_bin(f_name):
    """
    Зчитує результат з двійкового файлу.
    
    :param f_name: ім'я файлу
    :return: зчитане числове значення
    """
    result = 0.0
    try:
        if os.path.exists(f_name):
            with open(f_name, 'rb') as f:
                # unpack повертає кортеж, беремо перший елемент [0]
                # 'd' означає, що очікуємо 8 байт (double)
                packed_data = f.read()
                if len(packed_data) >= 8:
                    result = struct.unpack('d', packed_data)[0]
                else:
                    print("Помилка: файл пошкоджено або пустий.")
        else:
            raise FileNotFoundError(f"Файл {f_name} не знайдено.")
    except (FileNotFoundError, struct.error) as e:
        print(f"Помилка читання з двійкового файлу: {e}")
        sys.exit(1)
    return result

# Головний блок виконання програми
if __name__ == "__main__":
    print("Лабораторна робота №8. Python: Робота з файлами.")
    
    try:
        # Введення даних
        data = float(input("Введіть значення кута X (у градусах): "))
        
        # Обчислення
        calc_result = calculate(data)
        print(f"Обчислений результат (y = tg({data})): {calc_result}")
        
        # Робота з текстовим файлом
        txt_file = "Lab8_Res.txt"
        write_res_txt(txt_file, calc_result)
        print(f"Дані записано у {txt_file}")
        
        read_txt = read_res_txt(txt_file)
        print(f"Дані зчитано з {txt_file}: {read_txt}")
        
        # Робота з двійковим файлом
        bin_file = "Lab8_Res.bin"
        write_res_bin(bin_file, calc_result)
        print(f"Дані записано у {bin_file}")
        
        read_bin = read_res_bin(bin_file)
        print(f"Дані зчитано з {bin_file}: {read_bin}")

    except ValueError as e:
        print(f"Помилка даних: {e}")
    except Exception as e:
        print(f"Виникла непередбачувана помилка: {e}")