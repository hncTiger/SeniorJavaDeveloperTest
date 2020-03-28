package com.hzh.codetest.service;

import com.hzh.codetest.eneity.Weather;

public interface WeatherService {
	
	Weather findCityWeather(String cityName);
	
}
