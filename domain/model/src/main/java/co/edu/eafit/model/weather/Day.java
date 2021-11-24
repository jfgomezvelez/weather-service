package co.edu.eafit.model.weather;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Day {
    private final String datetime;
    private final int datetimeEpoch;
    private final double tempmax;
    private final double tempmin;
    private final double temp;
    private final double feelslikemax;
    private final double feelslikemin;
    private final double feelslike;
    private final double dew;
    private final double humidity;
    private final double precip;
    private final double precipprob;
    //private final Object precipcover;
    private final List<String> preciptype;
    private final double snow;
    private final double snowdepth;
    private final double windgust;
    private final double windspeed;
    private final double winddir;
    private final double pressure;
    private final double cloudcover;
    private final double visibility;
    private final double solarradiation;
    private final double solarenergy;
    private final double uvindex;
    private final double severerisk;
    private final String sunrise;
    private final int sunriseEpoch;
    private final String sunset;
    private final int sunsetEpoch;
    private final double moonphase;
    private final String conditions;
    private final String description;
    private final String icon;
    private final List<String> stations;
    private final String source;
    private final List<Hour> hours;
}