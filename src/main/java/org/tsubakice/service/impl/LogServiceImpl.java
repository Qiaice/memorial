package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.mapper.LogMapper;
import org.tsubakice.service.LogService;

@Service
public class LogServiceImpl implements LogService {

    private final LogMapper logMapper;

    @Autowired
    public LogServiceImpl(LogMapper logMapper) {
        this.logMapper = logMapper;
    }
}
