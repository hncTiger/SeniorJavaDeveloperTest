package com.hzh.codetest;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzh.codetest.service.WeatherService;

public class WeatherTest extends BaseTest{
	@Autowired
	private WeatherService weatherService;
	
	
	@Test
    public void testGetWeatherByCityName(){
        
        //System.out.println(weatherService.findCityWeather("大连").getWeather());
        //System.out.println(weatherService.findCityWeather("大连").getTemperature());
        //System.out.println(weatherService.findCityWeather("大连").getWind());
		Assert.assertEquals("没有正常返回天气信息","晴",weatherService.findCityWeather("大连").getWeather());
    }
}
