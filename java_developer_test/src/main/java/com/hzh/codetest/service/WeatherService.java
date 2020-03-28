package com.hzh.codetest.service;

import com.hzh.codetest.entity.Weather;

public interface WeatherService {
	
	Weather findCityWeather(String cityName);
	
}
