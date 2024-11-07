package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.mapper.FacilityMapper;
import org.tsubakice.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityMapper facilityMapper;

    @Autowired
    public FacilityServiceImpl(FacilityMapper facilityMapper) {
        this.facilityMapper = facilityMapper;
    }
}
