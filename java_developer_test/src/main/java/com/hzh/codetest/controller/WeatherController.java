package com.hzh.codetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hzh.codetest.entity.Weather;
import com.hzh.codetest.respone.converter.ResultWrapper;
import com.hzh.codetest.service.WeatherService;

@RestController
public class WeatherController {
	
	 @Autowired
	 private WeatherService weatherService;
	
	//获取城市天气信息
    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public ResponseEntity<ResultWrapper> getCityWeather(
        @RequestParam(value = "cityName") String cityName) {
        
    	Weather weather = weatherService.findCityWeather(cityName);
    	return ResponseEntity.ok(new ResultWrapper(weather));
    	
    }
    
    //PlanB
}
