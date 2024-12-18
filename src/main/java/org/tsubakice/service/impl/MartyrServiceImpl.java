package org.tsubakice.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsubakice.data.table.Martyr;
import org.tsubakice.data.view.MartyrInfoView;
import org.tsubakice.data.view.MartyrItemView;
import org.tsubakice.mapper.MartyrMapper;
import org.tsubakice.service.MartyrService;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<MartyrItemView> getAllMartyrsByCid(Integer cid) {
        return martyrMapper.selectAllMartyrsByCid(cid).stream().map(MartyrItemView::new).toList();
    }

    @Override
    public Map<String, Object> getAllMartyrsByPage(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Martyr> martyrs = martyrMapper.selectAllMartyrs();
        Page<Martyr> pages = (Page<Martyr>) martyrs;
        return Map.of("total", pages.getTotal(), "list", pages.getResult());
    }
}
