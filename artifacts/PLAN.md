# **План автоматизации тестирования**

## **Цели проекта**
- Проверка корректной работы ключевых элементов страницы оплаты.
- Обеспечение надежности обработки платежей.
- Выявление ошибок и некорректной обработки данных.
- Повышение эффективности тестирования за счет автоматизации.

## **Автоматизированные сценарии**

### **Позитивные сценарии**
- Успешное появление формы оплаты по карте после нажатия на кнопку "Купить".
- Успешное появление формы "Кредит по данным карты" после нажатия на кнопку "Купить в кредит".
- Успешная обработка платежа при вводе валидных данных.
- Отклонение платежа при вводе номера карты со статусом "Declined".

### **Негативные сценарии**

#### Поле "Номер карты"
- Ввод несуществующего в базе номера из 16 цифр.
- Ввод номера, длина которого отличается от стандартной (13, 15, 18 или 19 цифр).
- Ввод невалидных символов: *?: и других.
- Ввод букв или кириллицы.
- Оставление поля пустым.

#### Поле "Месяц"
- Ввод чисел больше 12.
- Ввод букв или символов: )*_ и т.д.
- Ввод одной цифры.
- Оставление поля пустым.

#### Поле "Год"
- Ввод истекшего года.
- Ввод букв или символов: )*_ и т.д.
- Ввод года, превышающего текущий более чем на 10 лет.
- Ввод одной цифры.
- Оставление поля пустым.

#### Поле "Владелец"
- Ввод кириллицы.
- Ввод одного слова вместо имени и фамилии.
- Ввод цифр.
- Ввод невалидных символов: )*? и т.д.
- Ввод одной буквы.
- Ввод текста длиной более 100 символов.
- Ввод двойной фамилии через дефис.
- Оставление поля пустым.

#### Поле "CVC/CVV"
- Ввод букв или символов: *?: и других.
- Ввод одной или четырех цифр.
- Оставление поля пустым.

### **Дополнительные сценарии**
- Оставление всех полей формы пустыми.

### **Тестирование запросов в СУБД**
- Проверка корректности записи данных при вводе карты со статусом `Approved`.
- Проверка корректности записи данных при вводе карты со статусом `Declined`.

## **Инструменты**
- **IntelliJ IDEA Ultimate** — интегрированная среда разработки.
- **Java 11** — строго типизированный объектно-ориентированный язык программирования.
- **JUnit 5** — платформа для модульного тестирования.
- **Selenide** — фреймворк для автоматизированного тестирования веб-приложений.
- **Lombok** — плагин для уменьшения количества кода.
- **JavaFaker** — библиотека для генерации случайных данных.
- **Allure** — фреймворк для сбора данных и построения отчетов.
- **Docker** — платформа для работы с контейнерами.

## **Возможные риски**
- Сложности с первым запуском SUT и БД из-за недостатка знаний.
- Увеличение времени работы из-за недостаточной мощности ПК.
- Необходимость редактирования тестов при изменении интерфейса или данных.
- Возможные ошибки интеграции с API и СУБД.

## **Способы минимизации рисков**
- Подготовка моков для API банка.
- Предварительное тестирование подключения к БД.
- Использование CI/CD для своевременного запуска тестов.

## **Интервальная оценка времени**
- **Подготовка проекта, изучение ТЗ, настройка ПО и запуск SUT**: 12 часов.
- **Написание плана тестирования**: 2 часа.
- **Разработка автотестов**: 24–48 часов.
- **Подготовка отчетов**: 3 часа.
- **Резервное время на решение сложностей**: 8 часов.

**Итого**: от 41 до 73 часов.

## **План сдачи работ**
- **Подготовка плана тестирования**: 1 день после запуска SUT — 27.12.2024.
- **Разработка автотестов**: от 3 до 6 дней — 30.12.2024 – 03.01.2025.
- **Подготовка отчетов**: 1 день после завершения автотестов — 04.01.2025.

## **Критерии завершения**
- Все автотесты успешно выполняются.
- Негативные сценарии корректно обрабатываются.
- Подготовлены подробные отчеты в Allure.
