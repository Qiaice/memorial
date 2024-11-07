package org.tsubakice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.tsubakice.service.MartyrService;

@RestController
public class MartyrController {

    private final MartyrService martyrService;

    @Autowired
    public MartyrController(MartyrService martyrService) {
        this.martyrService = martyrService;
    }
}
