package ru.myweathersait.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.myweathersait.entity.WeatherHistoryEntity;
import ru.myweathersait.repository.WeatherHistoryEntityRepository;

@Configuration
public class LoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDataBaseStatusProject(WeatherHistoryEntityRepository weatherHistoryEntityRepository) {
        return args -> {
            log.info("Preloading " + weatherHistoryEntityRepository
                    .save(new WeatherHistoryEntity(4L, "66-66-66", "фиговская погода сегодня")));
        };
    }
}