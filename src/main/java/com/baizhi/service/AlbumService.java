package com.baizhi.service;

import com.baizhi.entity.Album;

import java.util.List;

public interface AlbumService {
    //通过页号查询
    public List<Album> selectByPage(Integer start, Integer rows);

    //查询总条数
    public Integer count();

    //添加
    public String add(Album album);

    //删除
    public void delete(String[] ids);

    //修改
    public void updateUrl(Album album);

    public void updateStatus(Album album);
}
