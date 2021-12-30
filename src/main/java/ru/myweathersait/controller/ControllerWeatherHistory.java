package ru.myweathersait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.myweathersait.dao.WeatherHistoryDao;
import ru.myweathersait.entity.WeatherHistoryEntity;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerWeatherHistory {

    private final WeatherHistoryDao weatherHistoryDao;

    @Autowired
    public ControllerWeatherHistory(WeatherHistoryDao weatherHistoryDao) {
        this.weatherHistoryDao = weatherHistoryDao;
    }

    @GetMapping("/all")
    public List<WeatherHistoryEntity> findAllWeatherHistoryWhichAreInDataBase(){
       return weatherHistoryDao.findAll();
    }

    @PostMapping("/weather")
    public Object weatherToday(@RequestBody WeatherHistoryEntity weatherHistoryEntity) throws IOException {
       return weatherHistoryDao.findByWeatherCurrentData(weatherHistoryEntity);
    }


}
