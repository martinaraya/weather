package training.weather.client.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.api.client.http.HttpRequest;

import training.weather.client.ClienteAbstracto;

public class MetaWeatherClient extends ClienteAbstracto {
	private static final Logger log = Logger.getLogger(MetaWeatherClient.class.getName());
	private static final String APIURL = "https://www.metaweather.com/api/location";
	private static final String METHOD_SEARCHQUERY = "/search/?query=%s";
	private static final String METHOD_SEARCH = "/";

	public MetaWeatherClient() {
		super(APIURL);
	}

	public MetaWeatherClient(String url) {
		// en caso se neceiste enviar a otra URL. el cliente se crea con el URL nuevo
		super(url);
	}

	public String getWoeByCityName(String cityName) {

		log.info("Getting city by name");
		HttpRequest request = createClient(getSearchQuery(cityName));
		String response;
		String woe = "";

		try {
			response = request.execute().parseAsString();
			log.info("Parsing request");
			JSONArray array = new JSONArray(response);
			if (array.length() > 0) {
				woe = array.getJSONObject(0).get("woeid").toString();
				log.info("woe: " + woe);
			}else {
				log.info("respuesta vacía ");
			}
		} catch (IOException e) {
			log.severe("Error llamando a getWoeByCityName");
			e.printStackTrace();
		}
		return woe;
	}

	public String getCityWeatherByWoeAndDate(String woe, Date dateTime) {
		log.info("Getting city weather by woe");
		HttpRequest request = createClient(getSearch(woe));
		String response;
		String result = "";

		try {

			response = request.execute().parseAsString();
			log.info("Parsing request");
			JSONArray results = new JSONObject(response).getJSONArray("consolidated_weather");
			
			log.info(String.format("respuesta con %d elementos ", results.length())) ;
			
			for (int i = 0; i < results.length(); i++) {
				if (new SimpleDateFormat("yyyy-MM-dd").format(dateTime)
						.equals(results.getJSONObject(i).get("applicable_date").toString())) {
					result = results.getJSONObject(i).get("weather_state_name").toString();
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.severe("Error llamando a getCityWeatherByWoeAndDate");
			e.printStackTrace();
		}
		return result;
	}

	private static String getSearchQuery(String city) {
		return String.format(METHOD_SEARCHQUERY, city);
	}

	private static String getSearch(String woe) {
		return String.format(METHOD_SEARCH).concat(woe);
	}

}
