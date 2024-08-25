package com.example.demo.configs;

import com.example.demo.BloomFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BloomFilterConfig {
    @Bean
    public BloomFilter bloomFilter() {
        return new BloomFilter(10000, 3);
    }
}
