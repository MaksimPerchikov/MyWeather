package ru.myweathersait.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.myweathersait.entity.WeatherHistoryEntity;

@Repository
public interface WeatherHistoryEntityRepository extends JpaRepository<WeatherHistoryEntity,Long> {

}
