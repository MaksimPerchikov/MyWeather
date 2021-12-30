package ru.myweathersait.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "weather_history")
public class WeatherHistoryEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Value("weather_date")
    private Date weatherDate;
    @Value("weather_value")
    private String weatherValue;

    public WeatherHistoryEntity(Date weatherDate) {
        this.weatherDate = weatherDate;
    }
}
