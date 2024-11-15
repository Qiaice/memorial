package org.tsubakice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.resource.Result;
import org.tsubakice.service.CityService;

@Tag(name = "城市管理模块")
@RestController
@RequestMapping(value = { "/cities" }, produces = { "application/json; charset=utf-8" })
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Operation(
            summary = "获取所有城市信息接口",
            description = "城市信息包含城市名称和城市 id"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "GET_ALL_CITIES_SUCCESS", description = "获取所有城市信息成功"),
            @ApiResponse(responseCode = "GET_ALL_CITIES_FAIL", description = "获取所有城市信息失败")
    })
    @GetMapping(value = { "/all" })
    public Result getAllCities() {
        return null;
    }
}
