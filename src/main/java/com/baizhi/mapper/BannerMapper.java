package com.baizhi.mapper;

import com.baizhi.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BannerMapper {
    public List<Banner> selectAll();

    public void save(Banner banner);

    public void update(Banner banner);

    public void delete(String id);

    public void updateImg(@Param("id") String id, @Param("newPath") String newPath);

    //通过页号查询
    public List<Banner> selectByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    //查询总条数
    public Integer count();
}
