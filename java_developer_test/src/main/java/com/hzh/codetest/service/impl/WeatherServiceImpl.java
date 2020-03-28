package com.hzh.codetest.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzh.codetest.entity.Weather;
import com.hzh.codetest.entity.WeatherByCity;
import com.hzh.codetest.entity.WeatherByCity.ResultBean.FutureBean;
import com.hzh.codetest.repository.WeatherRepsitory;
import com.hzh.codetest.service.WeatherService;

@Service
//@SuppressWarnings("unchecked")
public class WeatherServiceImpl implements WeatherService{

	@Autowired
	private WeatherRepsitory weatherRepsitory;
	 
	@Override
	public Weather findCityWeather(String cityName) {

		JSONObject object = weatherRepsitory.getWeatherByCity(cityName);
		Weather weather = new Weather();
		if(object != null && object.getInteger("error_code")==0){
			//解析一下
			WeatherByCity weatherByCity = JSON.parseObject(object.toJSONString(), WeatherByCity.class);
			
			List<FutureBean> futureBeans = weatherByCity.getResult().getFuture().stream()
		            .filter(item -> getCurrentDateTime().equals(item.getDate())).collect(Collectors.toList());
			
			if (!CollectionUtils.isEmpty(futureBeans)) {
				weather.setTemperature(futureBeans.get(0).getTemperature());
				weather.setUpdatedTime(futureBeans.get(0).getDate() + " " + getCurrentTime());
				weather.setWeather(futureBeans.get(0).getWeather());
				weather.setWind(futureBeans.get(0).getDirect());
	        }           
		}		
		return weather;
	}
	
	public static String getCurrentDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDateTime.now().format(formatter);
	}
	
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("hh:mm:ss");
		return dateFormat.format(date);
	}

}
