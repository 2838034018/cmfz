package com.baizhi.mapper;

import com.baizhi.entity.Chapter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChapterMapper {
    //通过页号查询
    public List<Chapter> selectByPage(@Param("start") Integer start, @Param("rows") Integer rows, @Param("albumId") String albumId);

    //查询总条数
    public Integer count(String id);

    public void add(Chapter chapter);

    public void updateUrl(Chapter chapter);

    public void del(String[] id);
}
