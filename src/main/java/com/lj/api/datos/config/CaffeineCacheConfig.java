package com.lj.api.datos.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

//@Configuration
//@EnableCaching
public class CaffeineCacheConfig {
//
//    @Bean
//    public Caffeine caffeine(){
//        return Caffeine.newBuilder()
//                .expireAfterAccess(60, TimeUnit.MINUTES);
//    }
//
//    @Bean
//    public CacheManager cacheManager(Caffeine caffeine){
//        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
//        caffeineCacheManager.getCache("addresses");
//        caffeineCacheManager.setCaffeine(caffeine);
//        return caffeineCacheManager;
//    }
}
