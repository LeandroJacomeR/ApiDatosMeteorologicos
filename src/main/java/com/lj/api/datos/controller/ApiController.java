package com.lj.api.datos.controller;

import com.lj.api.datos.dto.api.forecast.ApiForecastDto;
import com.lj.api.datos.entity.response.ApiResponse;
import com.lj.api.datos.service.ApiService;
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

    private ApiResponse apiResponse;

    @GetMapping("/response")
    public ResponseEntity<ApiResponse> apiResponse(double lat, double lon){
        ApiResponse response = apiService.apiResponse(lat, lon);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/response/{city}")
    public ResponseEntity<ApiResponse> apiResponse(@PathVariable("city") String city){
        apiResponse = apiService.apiResponseCity(city);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/response/forecast/{city}")
    public ResponseEntity<ApiForecastDto> apiForecastDto(@PathVariable("city") String city){
        ApiForecastDto apiResponse = apiService.apiResponseDays(city);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
