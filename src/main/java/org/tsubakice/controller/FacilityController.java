package org.tsubakice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.service.FacilityService;

@RestController
@RequestMapping(value = { "/facilities" }, produces = { "application/json; charset=utf-8" })
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }
}
