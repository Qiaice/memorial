package org.tsubakice.service;

import org.tsubakice.data.table.Facility;
import org.tsubakice.data.view.FacilityView;

import java.util.List;
import java.util.Map;

public interface FacilityService {

    List<FacilityView> list();

    Facility getByFid(Integer fid);

    Map<String, Object> listByPage(Integer page, Integer pageSize);
}
