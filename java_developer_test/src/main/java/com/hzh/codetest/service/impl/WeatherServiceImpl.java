package com.hzh.codetest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.hzh.codetest.eneity.Weather;
import com.hzh.codetest.repository.WeatherRepsitory;
import com.hzh.codetest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	private WeatherRepsitory weatherRepsitory;
	 
	@Override
	public Weather findCityWeather(String cityName) {

		JSONObject object = weatherRepsitory.getWeatherByCity(cityName);
		Weather weather = null;
		if(object != null){
			if(object.getInteger("error_code")==0){
				//解析一下
				JSONObject resultObject = object.getJSONObject("result");				
				List<Map<String, Object>> futureListMap = JSON.parseObject(resultObject.getJSONObject("future").toJSONString(), new TypeReference<List<Map<String,Object>>>(){});  

				
				
            }
		}
		weather.setTemperature("aaa");
		weather.setUpdatedTime("bbb");
		weather.setWeather("ccc");
		weather.setWind("ddd");
		return weather;
		//return null;
	}

}
