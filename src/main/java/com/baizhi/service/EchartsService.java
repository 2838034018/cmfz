package com.baizhi.service;

import com.baizhi.entity.EchartsMap;

import java.util.List;

public interface EchartsService {
    public List<EchartsMap> selectAll();

    public List<Integer> query();
}
