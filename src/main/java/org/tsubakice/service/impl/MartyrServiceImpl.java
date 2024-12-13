package org.tsubakice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.view.MartyrInfoView;
import org.tsubakice.data.view.MartyrItemView;
import org.tsubakice.mapper.MartyrMapper;
import org.tsubakice.service.MartyrService;

import java.util.List;

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

    @Override
    public List<MartyrItemView> getAllMartyrItem() {
        return martyrMapper.selectAllMartyrs().stream().map(MartyrItemView::new).toList();
    }
}
