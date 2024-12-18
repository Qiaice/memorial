package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.view.FacilityView;
import org.tsubakice.mapper.FacilityMapper;
import org.tsubakice.service.FacilityService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityMapper facilityMapper;

    @Autowired
    public FacilityServiceImpl(FacilityMapper facilityMapper) {
        this.facilityMapper = facilityMapper;
    }

    @Override
    public List<FacilityView> list() {
        return facilityMapper.list().stream().map(item -> {
            FacilityView view = new FacilityView();
            view.setFid(item.getFid());
            view.setName(item.getName());
            view.setImg("https://www.sctyjrsw.com/image" + item.getImg());
            return view;
        }).collect(Collectors.toList());
    }
}
