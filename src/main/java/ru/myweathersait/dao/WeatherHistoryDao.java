package ru.myweathersait.dao;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myweathersait.entity.WeatherHistoryEntity;
import ru.myweathersait.repository.WeatherHistoryEntityRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WeatherHistoryDao {
    private Integer i;
    public Integer getI() {return i;}
    public void setI(Integer i) {this.i = i;}

    private final WeatherHistoryEntityRepository weatherHistoryEntityRepository;


    @Autowired
    public WeatherHistoryDao(WeatherHistoryEntityRepository weatherHistoryEntityRepository) {
        this.weatherHistoryEntityRepository = weatherHistoryEntityRepository;
    }

    //поиск прогноза погоды по текущей дате
    public Optional<WeatherHistoryEntity> findByWeatherCurrentData(WeatherHistoryEntity weatherHistoryEntity) throws IOException {
        try{
            List<WeatherHistoryEntity> weatherHistoryEntityList
                                    = weatherHistoryEntityRepository.findAll();
            Optional<WeatherHistoryEntity> weatherHistoryEntityOptional = weatherHistoryEntityList.stream()
                    .filter(element -> element.getWeatherDate().equals(weatherHistoryEntity.getWeatherDate()))
                    .findFirst();

            return weatherHistoryEntityOptional;

        }catch (Exception e){
            Document page = getPage();
            Element date = page.select("span[class=datetime__date]").first();
            String day = date.select("span[class=datetime__day]").text();
            String month = date.select("span[class=datetime__month]").text();

            System.out.println(day+ "."+month);

        }
        return null;
    }



    //метод,показывающий страницу яндекса
    private static Document getPage() throws IOException{
        String url = "https://yandex.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    //метод преобразования строки месяца в целочисленное
    public Integer searchMonth(String str){
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
