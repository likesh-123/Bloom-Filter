package com.example.demo.services;

import com.example.demo.BloomFilter;
import org.springframework.stereotype.Service;

@Service
public class BloomFilterService {

    private final BloomFilter bloomFilter;

    public BloomFilterService(BloomFilter bloomFilter) {
        this.bloomFilter = bloomFilter;
    }

    public String addElement(String element) {
        for (int i = 0; i < bloomFilter.getHashFunctionsCount(); i++) {
            int hash = bloomFilter.getHash(element, i);
            bloomFilter.getBitSet().set(Math.abs(hash % bloomFilter.getSize()), true);
        }
        return "Element added successfully";
    }

    public boolean mightContain(String element) {
        for (int i = 0; i < bloomFilter.getHashFunctionsCount(); i++) {
            int hash = bloomFilter.getHash(element, i);
            if (!bloomFilter.getBitSet().get(Math.abs(hash % bloomFilter.getSize()))) {
                return false;
            }
        }
        return true;
    }
}
