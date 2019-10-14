package com.baizhi.serviceImpl;

import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumMapper albumMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Album> selectByPage(Integer page, Integer rows) {
        Integer start = (page - 1) * rows;
        List<Album> albums = albumMapper.selectByPage(start, rows);
        return albums;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer count() {
        Integer count = albumMapper.count();
        return count;
    }

    @Override
    public String add(Album album) {
        String s = UUID.randomUUID().toString();
        album.setId(s);
        album.setCreateDate(new Date());
        albumMapper.save(album);
        return s;
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            albumMapper.delete(id);
        }
    }

    @Override
    public void updateUrl(Album album) {
        albumMapper.updateUrl(album);
    }

    @Override
    public void updateStatus(Album album) {
        albumMapper.updateStatus(album);
    }


}
