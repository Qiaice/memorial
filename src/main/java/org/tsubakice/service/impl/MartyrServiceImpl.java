package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.view.MartyrInfoView;
import org.tsubakice.mapper.MartyrMapper;
import org.tsubakice.service.MartyrService;

@Service
public class MartyrServiceImpl implements MartyrService {

    private final MartyrMapper martyrMapper;

    @Autowired
    public MartyrServiceImpl(MartyrMapper martyrMapper) {
        this.martyrMapper = martyrMapper;
    }

    @Override
    public MartyrInfoView getMartyrById(Integer mid) {
        return new MartyrInfoView(martyrMapper.selectMartyrById(mid));
    }
}
