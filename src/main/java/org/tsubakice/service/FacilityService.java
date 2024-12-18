package org.tsubakice.service;

import org.tsubakice.data.table.Facility;
import org.tsubakice.data.view.FacilityView;

import java.util.List;

public interface FacilityService {
    List<FacilityView> list();

    Facility getByFid(Integer fid);
}
