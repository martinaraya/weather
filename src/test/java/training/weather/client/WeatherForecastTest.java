package training.weather.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.Date;
import org.junit.Test;

import training.weather.service.WeatherForecast;

public class WeatherForecastTest {

	@Test
	public void unfinished_test() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", new Date());
		assertNotEquals("", forecast);
	}
	
	@Test
	public void testCiudadNoExiste() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("MadridXXX", new Date());
		assertEquals("", forecast);
	}
	
	@Test
	public void testFechaMasDeSeisDias() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 7)));
		assertEquals("", forecast);
	}
	
	@Test
	public void testFechaPasada() throws IOException {
		WeatherForecast weatherForecast = new WeatherForecast();
		String forecast = weatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() - (1000 * 60 * 60 * 24 * 14)));
		assertEquals("", forecast);
	}
	
}