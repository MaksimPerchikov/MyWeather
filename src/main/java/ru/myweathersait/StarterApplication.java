package ru.myweathersait;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
@SpringBootApplication
public class StarterApplication {
    private static Integer i;

    public static Integer getI() {
        return i;
    }

    public static void setI(Integer i) {
        StarterApplication.i = i;
    }


    private static Document getPage() throws IOException {
        String url = "https://yandex.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    public static void main(String[] args) throws IOException{

        Document page = getPage();
        System.out.println(page);
        /*Element date = page.select("span[class=datetime__date]").first();
        String day = date.select("span[class=datetime__day]").text();
        String month = date.select("span[class=datetime__month]").text();
        Integer monthNumber = searchMonth(month);
        System.out.println(day+ "."+monthNumber);


        System.out.println("  Погода  ");
        Element wth = page.select("div[class=weather__content]").first();*/
      //  System.out.println(wth);
       // System.out.println(jsonVersion);

    }

   public static Integer searchMonth(String str){

        switch (str){
            case "декабря,":
                setI(12);
                break;
            case "января":
                setI(1);
                break;
            case "февраля":
                setI(2);
                break;
            case "марта":
                setI(3);
                break;
            case "апреля":
                setI(4);
                break;
            case "мая":
                setI(5);break;
            case "июня":
                setI(6);break;
            case "июля":
                setI(7);break;
            case "августа":
                setI(8);break;
            case "сентября":
                setI(9);break;
            case "октября":
                setI(10);break;
            case "ноября":
                setI(11);break;
        }
        return getI();

    }
}
