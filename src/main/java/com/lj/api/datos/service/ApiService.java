package com.lj.api.datos.service;

import com.lj.api.datos.dto.cities.ApiResponseCity;
import com.lj.api.datos.entity.air.ApiAir;
import com.lj.api.datos.entity.air.ApiAirList;
import com.lj.api.datos.entity.forecast.ApiForecast;
import com.lj.api.datos.entity.forecast.ApiResponseForecast;
import com.lj.api.datos.entity.response.ApiResponse;
import com.lj.api.datos.entity.response.Weather;
import com.lj.api.datos.repository.air.ApiAirListRepository;
import com.lj.api.datos.repository.air.ApiAirRepository;
import com.lj.api.datos.repository.forecast.ApiForecastRepository;
import com.lj.api.datos.repository.forecast.ApiResponseForecastRepository;
import com.lj.api.datos.repository.response.ApiResponseRepository;
import com.lj.api.datos.repository.response.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiService {

    @Value("${external.api.key}")
    private String apiKey;
    @Value("${base.url}")
    private String url;
    @Value("${base.url-air}")
    private String urlApi;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ApiResponseRepository apiResponseRepository;
    @Autowired
    private ApiForecastRepository apiForecastRepository;
    @Autowired
    private ApiResponseForecastRepository apiResponseForecastRepository;
    @Autowired
    private ApiAirRepository apiAirRepository;
    @Autowired
    private ApiAirListRepository apiAirListRepository;
    @Autowired
    private WeatherRepository weatherRepository;

    @Cacheable("addresses")
    public ApiResponse apiResponseCity(String city){
        List<ApiResponseCity> responseCities = cities(city);
        ApiResponseCity cityDat = responseCities.get(0);
        double lat = cityDat.getLat();
        double lon = cityDat.getLon();
        return getApiResponse(lat, lon);
    }

    @Cacheable("addresses")
    public ApiForecast apiResponseDays(String city){
        List<ApiResponseCity> responseCities = cities(city);
        ApiResponseCity cityDat = responseCities.get(0);
        double lat = cityDat.getLat();
        double lon = cityDat.getLon();
        return getForecastDays(lat, lon);
    }

    @Cacheable("addresses")
    public ApiAir getApiAirResponse(String city){
        List<ApiResponseCity> responseCities = cities(city);
        ApiResponseCity cityDat = responseCities.get(0);
        double lat = cityDat.getLat();
        double lon = cityDat.getLon();
        return getApiAir(lat, lon);
    }

    private List<ApiResponseCity> cities(String city){
        ApiResponseCity[] responseCity = restTemplate.getForObject(url + "geo/1.0/direct?q=" + city + "&limit=1" + "&appid=" + apiKey, ApiResponseCity[].class);
        return List.of(responseCity);
    }


    @Transactional
    public ApiResponse getApiResponse(double lat, double lon){
        ApiResponse apiResponse = restTemplate.getForObject(url + "data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiResponse.class);
        apiResponse = apiResponseRepository.save(apiResponse);

        for (Weather w:  apiResponse.getWeather()) {
            w.setApiResponse(apiResponse);
            weatherRepository.save(w);
        }
        return apiResponse;
    }

    @Transactional
    public ApiForecast getForecastDays(double lat, double lon){
        ApiForecast apiForecast = restTemplate.getForObject(url + "data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiForecast.class);
        apiForecast = apiForecastRepository.save(apiForecast);

        for (ApiResponseForecast f : apiForecast.getList()){
            f.setApiForecast(apiForecast);
            apiResponseForecastRepository.save(f);
        }
        return apiForecast;
    }

    @Transactional
    public ApiAir getApiAir(double lat, double lon){
        ApiAir apiAirResponse = restTemplate.getForObject(urlApi + "data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey, ApiAir.class);
        apiAirResponse = apiAirRepository.save(apiAirResponse);

        for (ApiAirList a: apiAirResponse.getList()){
            a.setApiAir(apiAirResponse);
            apiAirListRepository.save(a);
        }
        return apiAirResponse;
    }
}
