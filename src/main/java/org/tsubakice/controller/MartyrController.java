package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.data.table.Martyr;
import org.tsubakice.data.view.MartyrInfoView;
import org.tsubakice.common.ResCode;
import org.tsubakice.common.Result;
import org.tsubakice.data.view.MartyrItemView;
import org.tsubakice.service.MartyrService;

import java.util.List;
import java.util.Map;

@Tag(name = "烈士管理模块")
@RestController
@RequestMapping(value = { "/martyrs" }, produces = { "application/json; charset=utf-8" })
public class MartyrController {

    private final MartyrService martyrService;

    @Autowired
    public MartyrController(MartyrService martyrService) {
        this.martyrService = martyrService;
    }

    @Operation(
            summary = "获取所有简短烈士信息接口",
            description = "简短烈士信息仅包含烈士名称和烈士 id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "GET_ALL_MARTYRS_ITEM_SUCCESS", description = "获取所有简短烈士信息成功"),
            @ApiResponse(responseCode = "GET_ALL_MARTYRS_ITEM_FAIL", description = "获取所有简短烈士信息失败")
    })
    @GetMapping(value = { "/allItem" })
    public Result getAllMartyrs() {
        List<MartyrItemView> list = martyrService.getAllMartyrItem();
        return list.isEmpty() ?
                Result.fail(ResCode.GET_ALL_MARTYRS_ITEM_FAIL, "获取所有简短烈士信息失败") :
                Result.success(ResCode.GET_ALL_MARTYRS_ITEM_SUCCESS, "获取所有简短烈士信息成功", list);
    }

    @GetMapping(value = "/page")
    public Result getAllMartyrsByPage(Integer page, Integer pageSize) {
        Map<String, Object> map = martyrService.getAllMartyrsByPage(page, pageSize);
        List<Martyr> list = (List<Martyr>) map.get("list");
        return !list.isEmpty() ?
                Result.success(ResCode.SUCCESS, "查询成功", map) :
                Result.fail(ResCode.FAIL, "查询失败");
    }

    @Operation(
            summary = "根据烈士 id 查找对应烈士信息接口",
            description = "根据烈士 id 查找对应烈士信息"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "GET_MARTYRS_ITEM_SUCCESS", description = "获取烈士信息成功"),
            @ApiResponse(responseCode = "GET_MARTYRS_ITEM_FAIL", description = "获取烈士信息失败")
    })
    @GetMapping(value = { "/{mid}" })
    public Result getMartyrById(
            @PathVariable Integer mid
    ) {
        MartyrInfoView martyr = martyrService.getMartyrById(mid);
        return martyr != null ?
                Result.success(ResCode.GET_MARTYRS_ITEM_SUCCESS, "获取烈士信息成功", martyr) :
                Result.fail(ResCode.GET_MARTYRS_ITEM_FAIL, "获取烈士信息失败");
    }

    @Operation(
            summary = "根据城市 id 查找对应烈士信息集合",
            description = "根据城市 id 查找对应烈士信息集合"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "GET_ALL_MARTYRS_ITEM_BY_CID_SUCCESS", description = "获取烈士信息成功"),
            @ApiResponse(responseCode = "GET_ALL_MARTYRS_ITEM_BY_CID_FAIL", description = "获取烈士信息失败"),
    })
    @GetMapping(value = { "/byCity/{cid}" })
    public Result getAllMartyrsByCid(
            @PathVariable Integer cid
    ) {
        List<MartyrItemView> list = martyrService.getAllMartyrsByCid(cid);
        return list.isEmpty() ?
                Result.fail(ResCode.GET_ALL_MARTYRS_ITEM_BY_CID_FAIL, "获取烈士信息失败") :
                Result.success(ResCode.GET_ALL_MARTYRS_ITEM_BY_CID_SUCCESS, "获取烈士信息成功", list);
    }
}
