package com.hzh.codetest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@SuppressWarnings("unused")
public class WeatherByCity {
    private String reason;
    private ResultBean result;
    @JsonProperty("error_code")
    private int errorCode;
    @Data
    public static class ResultBean {

		private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;
        @Data
        public static class RealtimeBean {
            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;
        }
        @Data
        public static class FutureBean {
            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;
            @Data
            public static class WidBean {
                private String day;
                private String night;

            }
        }
    }
}
