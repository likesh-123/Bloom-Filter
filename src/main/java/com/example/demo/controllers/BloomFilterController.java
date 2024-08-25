package com.example.demo.controllers;

import com.example.demo.services.BloomFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloomfilter")
public class BloomFilterController {

    private final BloomFilterService bloomFilterService;

    @Autowired
    public BloomFilterController(BloomFilterService bloomFilterService) {
        this.bloomFilterService = bloomFilterService;
    }

    @PostMapping("/addElement")
    public String addElement(@RequestParam String element) {
        return bloomFilterService.addElement(element);
    }

    @GetMapping("/contains")
    public boolean mightContain(@RequestParam String element) {
        return bloomFilterService.mightContain(element);
    }
}
