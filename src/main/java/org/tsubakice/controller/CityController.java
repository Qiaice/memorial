package org.tsubakice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.service.CityService;

@RestController
@RequestMapping(value = { "/cities" }, produces = { "application/json; charset=utf-8" })
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
}
