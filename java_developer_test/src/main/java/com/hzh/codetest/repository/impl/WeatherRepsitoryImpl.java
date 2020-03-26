package com.hzh.codetest.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.hzh.codetest.repository.WeatherRepsitory;
import com.hzh.codetest.util.NetUtil;

@Repository
public class WeatherRepsitoryImpl implements WeatherRepsitory{
	
	@Value("${weatherapi.key}")
    private String key;
	
	@Value("${weatherapi.url}")
    private String apiUrl;
	
	@Override
	public JSONObject getWeatherByCity(String cityName){
        String result =null;
        Map<String,String> params = new HashMap<String,String>();//请求参数
            params.put("cityname",cityName);//要查询的城市，如：温州、上海、北京
            params.put("key", key);//应用APPKEY(应用详细页查询)
            params.put("dtype", "");//返回数据的格式,xml或json，默认json
  
            try {
				result =NetUtil.net(apiUrl, params, "GET");
				JSONObject object = JSONObject.parseObject(result);
				return object;
			} catch (Exception e) {				
				e.printStackTrace();
			}
        return null;
    }
}
