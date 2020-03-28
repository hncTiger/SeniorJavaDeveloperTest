package com.hzh.codetest.entity;

import lombok.Data;

//@Entity
@Data
public class Weather {
	private String updatedTime;
	private String weather;
	private String temperature ;
	private String wind;
}
