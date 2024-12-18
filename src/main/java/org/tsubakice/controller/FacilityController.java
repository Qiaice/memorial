package org.tsubakice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.common.ResCode;
import org.tsubakice.common.Result;
import org.tsubakice.data.table.Facility;
import org.tsubakice.data.view.FacilityView;
import org.tsubakice.service.FacilityService;

import java.util.List;

@RestController
@RequestMapping(value = { "/facilities" }, produces = { "application/json; charset=utf-8" })
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping(value = "/list")
    public Result list() {
        List<FacilityView> list = facilityService.list();
        return !list.isEmpty() ?
                Result.success(ResCode.SUCCESS, "查询成功", list) :
                Result.fail(ResCode.FAIL, "查询失败");
    }

    @GetMapping(value = "/{fid}")
    public Result get(
            @PathVariable Integer fid
    ) {
        Facility facility = facilityService.getByFid(fid);
        return facility != null ?
                Result.success(ResCode.SUCCESS, "查询成功", facility) :
                Result.fail(ResCode.FAIL, "查询失败");
    }
}
