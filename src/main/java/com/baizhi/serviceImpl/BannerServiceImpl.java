package com.baizhi.serviceImpl;

import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bannerMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Banner> selectAll() {
        return bannerMapper.selectAll();
    }

    @Override
    public void save(Banner banner) {
        bannerMapper.save(banner);
    }

    @Override
    public void update(Banner banner) {
        bannerMapper.update(banner);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            bannerMapper.delete(id);
        }
    }

    @Override
    public void updateImg(String bannerId, String newPath) {
        bannerMapper.updateImg(bannerId, newPath);
    }

    @Override
    public List<Banner> selectByPage(Integer page, Integer rows) {
        Integer start = (page - 1) * rows;
        List<Banner> list = bannerMapper.selectByPage(start, rows);
        return list;
    }

    @Override
    public Integer count() {
        Integer count = bannerMapper.count();
        return count;
    }

}
