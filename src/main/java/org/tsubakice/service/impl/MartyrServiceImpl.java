package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.mapper.MartyrMapper;
import org.tsubakice.service.MartyrService;

@Service
public class MartyrServiceImpl implements MartyrService {

    private final MartyrMapper martyrMapper;

    @Autowired
    public MartyrServiceImpl(MartyrMapper martyrMapper) {
        this.martyrMapper = martyrMapper;
    }
}
