package com.baizhi.service;

import com.baizhi.entity.Chapter;

import java.util.List;

public interface ChapterService {
    //通过页号查询
    public List<Chapter> selectByPage(Integer start, Integer rows, String albumId);

    public String add(Chapter chapter);

    public void updateUrl(Chapter chapter);

    public void del(String[] id);
}
