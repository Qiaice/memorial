package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.table.City;
import org.tsubakice.data.view.CityInfoView;
import org.tsubakice.mapper.CityMapper;
import org.tsubakice.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    @Override
    public List<CityInfoView> getAllCities() {
        List<City> cityList = cityMapper.getAll();
        List<CityInfoView> cityInfoViewList = new ArrayList<CityInfoView>();
        for (City city : cityList) {
            CityInfoView cityInfoView = new CityInfoView();
            cityInfoView.setCid(city.getCid());
            cityInfoView.setName(city.getName());
            cityInfoViewList.add(cityInfoView);
        }
        return cityInfoViewList;
    }
}
