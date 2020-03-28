package com.hzh.codetest.repository;

import com.alibaba.fastjson.JSONObject;

public interface WeatherRepsitory {
	JSONObject getWeatherByCity(String cityName);
}
