# chat
Цель создания приложения - реализация веб-чата.</br>
Структура приложения:</br>
main</br>
&nbsp;&nbsp; java</br>
&nbsp;&nbsp;&nbsp;&nbsp; broker</br>
&nbsp;&nbsp;&nbsp;&nbsp; configs</br>
&nbsp;&nbsp;&nbsp;&nbsp; domain</br>
&nbsp;&nbsp;&nbsp;&nbsp; helpers</br>
&nbsp;&nbsp;&nbsp;&nbsp; repositories</br>
&nbsp;&nbsp;&nbsp;&nbsp; ChatApplication.java</br>
&nbsp;&nbsp; resources</br>
&nbsp;&nbsp;&nbsp;&nbsp; templates</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; login</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; main</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; messageForm</br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; register</br>
&nbsp;&nbsp;&nbsp;&nbsp; application.properties</br>

<h3>В поддиректории java реализуется основная логика приложения:</h3></br>
В поддиректории broker - соединение с брокером сообщений и класс Message, который содержит в себе основную информацию о сообщении.</br></br>
В поддиректории configs - классы кофигурации MVC и Security.</br></br>
В поддиректории controllers - контроллеры для различных маппингов.</br></br>
В поддиректории domain - предметная область приложения - класс User, необходим для аутентификации пользователя, реализует UserDetails,
возвращается в методе loadUserbyUserName функционального интерфейса UserDetailsService.</br></br>
В поддиректории helpers:</br>
1. Класс RegistrationUser. Объект данного класса используется при регистрации, впоследствии конвертируется в объект User.</br>
2. Класс SessionMessages - синглтон, хранит все сообщения отправленные за время работы контекста приложения для их отображения на странице пользователя.</br>
3. Класс StringToMessageConverter - конвертирует полученную из формы строку в объект класса Message.</br>
</br>
В поддиректории repositories - интерфейс UserRepo, который расширяет CrudRepository. Через данный интерфейс реализуется ORM.</br></br>
ChatApplication.java - стартовый класс.
<h3>В поддиректории templates находятся файлы шаблонов представлений</h3></br>
Файлы шаблонов представлений необходимы для обработки полученных в параметрах запроса данных и их отображения на странице.</br></br>

В application.properties базовые настройки приложения:</br>
1. Порт развертывания сервера Apache Tomcat.
2. Работа с БД.
3. Подключение к брокеру сообщений.
