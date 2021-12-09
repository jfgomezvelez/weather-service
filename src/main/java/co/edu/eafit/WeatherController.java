package co.edu.eafit;

import co.edu.eafit.mongodb.ProcessData;
import co.edu.eafit.mongodb.StatisticRepository;
import co.edu.eafit.statistic.FeatureType;
import co.edu.eafit.statistic.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@RestController

@RequestMapping(value = "/api")
public class WeatherController {

    @Value("${weatherapi.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StatisticRepository statisticRepository;

    @GetMapping("/weather/{location}")
    public String getWeather(@PathVariable String location) {
        return checkWeather(location);
    }

    public String checkWeather(String location) {

        ProcessData process = new ProcessData(
                LocalTime.now(),
                ProcessType.CHECKWEATHER.toString(),
                FeatureType.BASICONLYHTTP.toString()
        );

        String weather = restTemplate.getForObject(url.concat(location), String.class);

        process.setFinishDate(LocalTime.now());
        process.setDataSize(weather.length());

        statisticRepository.save(process);

        return weather;
    }
}
