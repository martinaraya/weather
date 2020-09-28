package training.weather.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import training.weather.client.impl.MetaWeatherClient;

public class WeatherForecast {

	public String getCityWeather(String city, Date datetime) throws IOException {

		LocalDateTime localDateTime = LocalDateTime.now();

		String weather = "";
		if (datetime == null) {
			datetime = Date.from(localDateTime.toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		}
		if (datetime.before(
				Date.from(localDateTime.plusDays(6).toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {

			MetaWeatherClient metaWeatherClient = new MetaWeatherClient();
			String woe = metaWeatherClient.getWoeByCityName(city);
			if (!"".contentEquals(woe))
				weather = metaWeatherClient.getCityWeatherByWoeAndDate(woe, datetime);

		}
		return weather;
	}
}
