package com.baizhi.service;

import com.baizhi.entity.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> selectAll();

    public void save(Banner banner);

    public void update(Banner banner);

    public void delete(String[] ids);

    public void updateImg(String bannerId, String newPath);

    //通过页号查询
    public List<Banner> selectByPage(Integer start, Integer rows);

    //查询总条数
    public Integer count();
}
