package com.baizhi.controller;

import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @ResponseBody
    @RequestMapping("/selectByPage")
    public Map<String, Object> selectByPage(Integer page, Integer rows) {
        Integer count = albumService.count();
        Integer total = count % rows == 0 ? count / rows : count / rows + 1;
        List<Album> banners = albumService.selectByPage(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", banners);
        map.put("records", count);
        map.put("page", page);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/edit")
    public String edit(Album album, String oper, String[] id) {
        if (oper.equals("add")) {
            String add = albumService.add(album);
            return add;
        } else if (oper.equals("del")) {
            albumService.delete(id);
        } else {
            albumService.updateStatus(album);
        }
        return null;
    }


    @RequestMapping("/upload")
    public void upload(MultipartFile cover, String albumId, HttpSession session) {
        String realPath = session.getServletContext().getRealPath("/img");

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = cover.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + originalFilename;
        try {
            cover.transferTo(new File(realPath, newFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Album album = new Album();
        album.setId(albumId);
        album.setCover(newFileName);
        albumService.updateUrl(album);
    }
}
