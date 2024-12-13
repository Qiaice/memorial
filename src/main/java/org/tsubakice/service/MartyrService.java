package org.tsubakice.service;

import org.tsubakice.data.view.MartyrInfoView;
import org.tsubakice.data.view.MartyrItemView;

import java.util.List;

public interface MartyrService {

    MartyrInfoView getMartyrById(Integer mid);

    List<MartyrItemView> getAllMartyrItem();

    List<MartyrItemView> getAllMartyrsByCid(Integer cid);
}
