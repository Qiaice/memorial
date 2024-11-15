package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.resource.Result;
import org.tsubakice.service.MartyrService;

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
        return null;
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
        return null;
    }
}
