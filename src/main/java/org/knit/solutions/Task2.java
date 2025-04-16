package org.knit.solutions;
import org.knit.solutions.task2.SimpleUrl;
import org.knit.TaskDescription;


/***
 * Задача 2
 * Создайте класс SimpleUrl
 * глядя на URL ниже создайте как можно больше полей в классе SimpleUrl:
 * https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText
 * добавьте геттеры и сеттеры для полей
 * Переопределите метод toString() для вывода информации о полях класса:
 * protocol = https
 * address = test.ru
 * domainZone = ru
 * siteName = test
 * webpageName = page.jsp
 * webPageExtention = jsp
 * ....
 * Распарсите данный URL на переменные, создайте экземпляр класса SimpleUrl и выведите на экран
 * Дополнительно
 * попробуйте с другими URL в сети, подумайте как можно сгруппировать значения.
 *
 */
@TaskDescription(taskNumber = 2, taskDescription = "Url", href = "org.knit.solutions.Task2")
public class Task2 implements Solution {
    @Override
    public void execute() {
//        String urlValue = "https://test.ru/test/1072/page.jsp?intParam=12345&doubleParam=3.14&textParameter=someText";
        String urlValue = "https://yandex.ru/album/28252377/track/119351891";

        String[] urlParts = urlValue.split("://");
        String protocol = urlParts[0];
        String[] domainParts = urlParts[1].split("/")[0].split("\\.");  // делим домен на части
        String address = String.join(".", domainParts);  // Воссоздаем адрес

        String siteName = domainParts[0];
        String domainZone = domainParts[domainParts.length - 1];

        String webpageName = urlValue.split("/")[urlValue.split("/").length - 1].split("\\?")[0];  // последняя часть пути
        String webPageExtention = webpageName.contains(".") ? webpageName.split("\\.")[1] : "";

        // Создаем объект SimpleUrl
        SimpleUrl url = new SimpleUrl();
        url.setProtocol(protocol);
        url.setAddress(address);
        url.setDomainZone(domainZone);
        url.setSiteName(siteName);
        url.setWebpageName(webpageName);
        url.setWebPageExtention(webPageExtention);

        // Выводим объект
        System.out.println(url);
    }
}
