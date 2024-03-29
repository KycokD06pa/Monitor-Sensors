# Monitor Sensors CRUD приложение
## Стэк
- Java 17(JDK 17 required)
- Spring Boot 3, Spring Data Jpa 3, Spring Security 6
- Hibernate, Liquibase
- Swagger
- Mysql
- Postman
## Запуск
Для запуска  Jar файла нужно клонировать проект в свою IDE. После чего вызвать на Maven package *'Run Maven Build'*.

Будет создан MonitorSensors-0.0.1-SNAPSHOT.jar в пакете *target*, его можно запустить из терминала командой
```java
java -jar target/MonitorSensors-0.0.1-SNAPSHOT.jar
```
Либо же через IDE используя сочетание клавиш SHIFT + F10

### Запуск при помощи Docker
1. Нужно повторить действия для запука jar файла и создать его в папке *target*
2. Далее необходимо запусть *services* в *docker-compose.yml* после чего будет создан соответствующий контейнер и приложение запуститься

   
![image](https://github.com/KycokD06pa/firstSpringBootApp/assets/135359267/222f99ba-df8a-4948-80bd-8a4bfc9fd808)


Для полноценного использования программы вам понадобится инструмент для работы с API *'Postman'* для работы с запросами.
Также программа использует свободную реляционную систему управления базами данных MySQL.

## http://localhost:8080/agsr/test
Программа написана на порте 8080 при переходе, на который попросят авторизоваться на этот случай в программе есть 2 предустановленных пользователя
с 2 разными ролями:
1. **Administrator** - она позволяет выполнять любые действия в программе
2. **Viewer** - позволяет выполнять только запросы вывода и поиска
### Данные предустановленных пользователей
1. Administrator - name = 'admin', password = '2609'
2. Viewer - name = 'user', password = 'abcd'
### Создать своего пользователя
Для этого нужно перейти по адресу
### http://localhost:8080/agsr/test/users/save
и написать post запрос с использованием json. Переходя по этому адресу страница авторизации не будет запущена.

## Сущности
В приложении кроме пользователя есть еще основная сущность датчик (Sensor) *'http://localhost:8080/agsr/test/sensors'*  и 2 дополнительные: 
1. тип (Type)  - *'http://localhost:8080/agsr/test/sensors/types'* есть 4 предустановленных значения (Pressure, Voltage, Temperature, Humidity)
2. единица измерения (Unit) - *'http://localhost:8080/agsr/test/sensors/units'* есть 4 предустановленных значения (bar, voltage, °С, %)

### Каждая сущность обладает набором CRUD операций, с ними можно ознакомиться в swagger
### http://localhost:8080/swagger-ui/index.html
![image](https://github.com/KycokD06pa/Monitor-Sensors/assets/135359267/dd889c32-36ea-49f1-b983-bb59a4fe0eeb)

Всем дополнительным сущностям соответствует модель, в которой у них есть get-all и get-id запросы, а также обычные запросы на добавление и удаление и обновленние.
У основной сущности датчик (Sensor) имеется поиск по имени и модели, что реализованы на частичном поиске, также можно выбрать из get запросов вид полученого json-а 
в полном варианте и сокращенном. 




 
