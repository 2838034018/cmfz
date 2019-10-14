package com.baizhi.serviceImpl;

import com.baizhi.entity.EchartsMap;
import com.baizhi.mapper.EchartsMapper;
import com.baizhi.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EchartsServiceImpl implements EchartsService {
    @Autowired
    EchartsMapper echartsMapper;

    @Override
    public List<EchartsMap> selectAll() {
        return echartsMapper.selectAll();
    }

    @Override
    public List<Integer> query() {
        return echartsMapper.selectTime();
    }
}
