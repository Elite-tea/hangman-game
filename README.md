# Виселица
## Цель проекта:
Это мой первый совместный пет-проект с Сергеем Черносмага. Классическая игра в Виселицу или Балду рассчитана на одного пользователя.
По задумке, пользователю даётся шесть попыток и две заранее подсказанные буквы. Всего в слове восемь букв.
Так же, в программе должна быть реализация добавления слов, чтоб пользователь сам мог расширять список.
## Первая итерация
* класс Manager должен отвечать за добавление слова в HashMap, где ключ - слово в формате String, а значения - буквы слова в формате Character. Так же, он должен считывать отдельный файл в формате txt, в котором хранятся правила игры.
* класс Game реализует полный цикл игры
* в классе Main реализована печать меню и считывание команд пользователя
## Вторая итерация
* перевёл все комментарии и взаимодействие с пользователем на русский язык во всех классах
* добавил в resources новый файл со словами для игры
* добавил в класс Manager метод для считывания слов из файла и их сохранения в HashMap
## Третья итерация
* добавлен класс Hangman с методами printHangman(N)Try() для печати попыток пользователя угадать букву
## Четвёртая итерация
* заменена HashMap на List для более удобного получения слова
* в классе Game добавлен метод guessingALetter() для реализации игры
* обновлено добавление пользователем слова в список (теперь слово добавляется не в список внутри программы, а в отдельный файл формата txt)
## Пятая итерация
* добавлена возможность прослушивания музыки в классе Main
* реализован класс Game
* исправлены комментарии и код для более читабельного формата
