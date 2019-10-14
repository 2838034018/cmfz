package com.baizhi.controller;

import com.baizhi.entity.EchartsMap;
import com.baizhi.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/echarts")
public class EchartsController {
    @Autowired
    EchartsService echartsService;

    @RequestMapping("queryMap")
    public List<EchartsMap> queryMap() {
        List<EchartsMap> echartsMaps = echartsService.selectAll();
        return echartsMaps;
    }

    @RequestMapping("query")
    public List<Integer> query() {
        List<Integer> list = echartsService.query();
        return list;
    }
}
