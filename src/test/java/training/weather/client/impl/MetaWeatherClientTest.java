package training.weather.client.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class MetaWeatherClientTest {

	@Test
	public void getWoeByCityNameTest() throws IOException {
		MetaWeatherClient metaWeatherClient = new MetaWeatherClient();
		String woe = metaWeatherClient.getWoeByCityName("Lima");

		assertEquals("418440", woe);
	}

	@Test
	public void getWoeByCityNameInvalidoTest() throws IOException {
		MetaWeatherClient metaWeatherClient = new MetaWeatherClient();
		String woe = metaWeatherClient.getWoeByCityName("LimaXXX");		
		assertEquals("", woe);
	}
	
	@Test
	public void getCityWeatherByWoeAndDateTest() throws IOException {
		MetaWeatherClient metaWeatherClient = new MetaWeatherClient();
		String weather = metaWeatherClient.getCityWeatherByWoeAndDate("766273", new Date(new Date().getTime()));
		assertNotEquals("", weather); 
	}

}
