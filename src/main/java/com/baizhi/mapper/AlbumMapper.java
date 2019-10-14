package com.baizhi.mapper;

import com.baizhi.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumMapper {
    //通过页号查询
    public List<Album> selectByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    public Integer count();

    //添加
    public void save(Album album);

    //删除
    public void delete(String id);

    //修改
    public void updateUrl(Album album);

    public void updateStatus(Album album);

    public void updateCount(Album album);
}
