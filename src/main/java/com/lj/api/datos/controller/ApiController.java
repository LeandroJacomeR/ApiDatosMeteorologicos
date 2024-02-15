package com.lj.api.datos.controller;

import com.lj.api.datos.entity.air.ApiAir;
import com.lj.api.datos.entity.forecast.ApiForecast;
import com.lj.api.datos.entity.response.ApiResponse;
import com.lj.api.datos.service.ApiService;
import com.lj.api.datos.service.RateLimitService;
import io.github.bucket4j.ConsumptionProbe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiController {

    @Autowired
    private ApiService apiService;
    @Autowired
    private RateLimitService rateLimitService;

    private ApiResponse apiResponse;
    private ApiForecast apiForecast;
    private ApiAir apiAir;

    @GetMapping("/response")
    public ResponseEntity<ApiResponse> apiResponse(double lat, double lon){
        try{
                apiResponse = apiService.getApiResponse(lat, lon);
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("error al insertar el registro: " + e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/response/{city}")
    public ResponseEntity<ApiResponse> apiResponse(@PathVariable("city") String city){
        try{
                apiResponse = apiService.apiResponseCity(city);
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("error al insertar el registro: " + e.getMessage());
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/response/forecast/{city}")
    public ResponseEntity<ApiForecast> apiForecastResponse(@PathVariable("city") String city){
        try{
            apiForecast = apiService.apiResponseDays(city);
            return new ResponseEntity<>(apiForecast, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("error al insertar el registro: " + e.getMessage());
            return new ResponseEntity<>(apiForecast, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/response/air/{city}")
    public ResponseEntity<ApiAir> apiAirResponse(@PathVariable("city") String city){
        try{
            apiAir = apiService.getApiAirResponse(city);
            return new ResponseEntity<>(apiAir, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("error al insertar el registro: " + e.getMessage());
            return new ResponseEntity<>(apiAir, HttpStatus.BAD_REQUEST);
        }
    }
}
