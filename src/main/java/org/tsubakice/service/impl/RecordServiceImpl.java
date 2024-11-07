package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.mapper.RecordMapper;
import org.tsubakice.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {

    private final RecordMapper recordMapper;

    @Autowired
    public RecordServiceImpl(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }
}
