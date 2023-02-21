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

