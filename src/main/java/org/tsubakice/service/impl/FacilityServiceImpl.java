package org.tsubakice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.table.Facility;
import org.tsubakice.data.view.FacilityView;
import org.tsubakice.mapper.FacilityMapper;
import org.tsubakice.service.FacilityService;

import java.util.List;
import java.util.Map;
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

    @Override
    public Facility getByFid(Integer fid) {
        Facility facility = facilityMapper.selectByFid(fid);
        if (facility != null) { facility.setImg("https://www.sctyjrsw.com/image" + facility.getImg()); }
        return facilityMapper.selectByFid(fid);
    }

    @Override
    public Map<String, Object> listByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Facility> list = facilityMapper.list();
        if (!list.isEmpty()) {
            list.forEach(item -> item.setImg("https://www.sctyjrsw.com/image" + item.getImg()));
        }
        Page<Facility> pages = (Page<Facility>) list;
        return Map.of("total", pages.getTotal(), "list", pages.getResult());
    }
}
