package com.hzh.codetest.eneity;

import lombok.Data;

//@Entity
@Data
public class Weather {
	private String date;
	private String updatedTime;
	private String weather;
	private String temperature ;
	private String wind;
	private String direct;
}