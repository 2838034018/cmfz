package com.baizhi.mapper;

import com.baizhi.entity.EchartsMap;

import java.util.List;

public interface EchartsMapper {
    public List<EchartsMap> selectAll();

    public List<Integer> selectTime();
}
