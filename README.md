# GazpromneftTask
Stack: Java 17, Maven, MySql, Spring framwork.

1. В MainController введите в PATH путь до JSON дампа.
Например: "D:\\JSON\\ruwiki-20221212-cirrussearch-general.json"
2. Run.
3. http://localhost:8080/parse - парсинг из дампа
4. http://localhost:8080/info/{title}  {title} - введите имя страницы из пропарсенного дампа
5. http://localhost:8080/info/{category} {category} - введите имя категории из пропарсенного дампа
6. http://localhost:8080/ - вывод всех данных по title

Фронтенд не релаизован, но есть вся подготовка через Thymeleaf.

MySQL Wiki
![image](https://user-images.githubusercontent.com/106023944/220385242-11f6340f-ab86-4733-b79c-c62f3dabe55c.png)


MySql Category
![image](https://user-images.githubusercontent.com/106023944/220385446-5c31b40a-047a-47af-b8c6-7b5348abd026.png)
