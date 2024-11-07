package org.tsubakice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.service.RecordService;

@RestController
@RequestMapping(value = { "/records" }, produces = { "application/json; charset=utf-8" })
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }
}
