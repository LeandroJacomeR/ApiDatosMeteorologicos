package com.lj.api.datos.service;

import com.lj.api.datos.dto.api.cities.ApiResponseCity;
import com.lj.api.datos.dto.api.forecast.ApiForecastDto;
import com.lj.api.datos.dto.api.response.ApiResponseDto;
import com.lj.api.datos.entity.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {

    @Value("${external.api.key}")
    private String apiKey;
    private String url = "https://api.openweathermap.org/";

    @Autowired
    private RestTemplate restTemplate;

    public ApiResponse apiResponse(double lat, double lon){
        return restTemplate.getForObject(url + "data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiResponse.class);
    }

    public ApiResponse apiResponseCity(String city){
        List<ApiResponseCity> responseCities = cities(city);
        ApiResponseCity cityDat = responseCities.get(0);
        double lat = cityDat.getLat();
        double lon = cityDat.getLon();
        return apiResponse(lat, lon);
    }

    public ApiResponseDto apiResponseDto(double lat, double lon){
        return restTemplate.getForObject(url + "data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiResponseDto.class);
    }

    public ApiForecastDto apiResponseDays(String city){
        List<ApiResponseCity> responseCities = cities(city);
        ApiResponseCity cityDat = responseCities.get(0);
        double lat = cityDat.getLat();
        double lon = cityDat.getLon();
        return getForecastDays(lat, lon);
    }

    private ApiForecastDto getForecastDays(double lat, double lon){
        return restTemplate.getForObject(url + "data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiForecastDto.class);
    }


    private List<ApiResponseCity> cities(String city){
        ApiResponseCity[] responseCity = restTemplate.getForObject(url + "geo/1.0/direct?q=" + city + "&limit=1" + "&appid=" + apiKey, ApiResponseCity[].class);
        return List.of(responseCity);
    }
}
