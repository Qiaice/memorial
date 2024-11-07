package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.mapper.CityMapper;
import org.tsubakice.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }
}
