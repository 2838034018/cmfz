package com.baizhi.serviceImpl;

import com.baizhi.entity.Album;
import com.baizhi.entity.Chapter;
import com.baizhi.mapper.AlbumMapper;
import com.baizhi.mapper.ChapterMapper;
import com.baizhi.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;
    @Autowired
    AlbumMapper albumMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Chapter> selectByPage(Integer page, Integer rows, String albumId) {
        Integer start = (page - 1) * rows;
        List<Chapter> chapters = chapterMapper.selectByPage(start, rows, albumId);
        return chapters;
    }


    @Override
    public String add(Chapter chapter) {
        String s = UUID.randomUUID().toString();
        chapter.setId(s);
        chapter.setCreateDate(new Date());
        chapter.setFileLong("123");
        chapter.setFileSize("123");
        System.out.println(chapter.getCreateDate());
        chapterMapper.add(chapter);
        return s;
    }

    @Override
    public void updateUrl(Chapter chapter) {
        chapterMapper.updateUrl(chapter);
        Integer count = chapterMapper.count(chapter.getAlbumId());
        Album album = new Album();
        album.setCount(count);
        album.setId(chapter.getAlbumId());
        albumMapper.updateCount(album);
    }

    @Override
    public void del(String[] id) {
        chapterMapper.del(id);
    }


}
