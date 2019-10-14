package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/kindeditor")
public class Kindeditor {
    @RequestMapping("/upload")
    public Map<String, Object> upload(MultipartFile img, HttpServletRequest request) throws IOException {
        Map<String, Object> map = new HashMap<>();
        String realPath = request.getServletContext().getRealPath("/img");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String newFileName = new Date().getTime() + "_" + img.getOriginalFilename();
        img.transferTo(new File(realPath, newFileName));
        //获取当前网站的协议名
        String scheme = request.getScheme();
        //获取本机IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        //获取端口号
        int port = request.getServerPort();
        //获取项目名
        String path = request.getContextPath();

        String url = scheme + "://" + hostAddress + ":" + port + path + "/img/" + newFileName;

        map.put("error", 0);
        map.put("url", url);
        return map;
    }

    @RequestMapping("/allImages")
    public Map<String, Object> all(HttpSession session, HttpServletRequest request) throws UnknownHostException {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        String realPath = session.getServletContext().getRealPath("img");
        File file = new File(realPath);
        String[] allimg = file.list();
        for (String s : allimg) {
            Map<String, Object> map1 = new HashMap<>();
            map1.put("is_dir", false);
            map1.put("has_file", file);
            //获取文件大小
            File file1 = new File(realPath, s);
            long length = file1.length();
            map1.put("filesize", length);
            map1.put("dir_path", "");
            map1.put("is_photo", true);
            //获取文件后缀名
            String s1 = s.substring(s.lastIndexOf(".") + 1);
            map1.put("filetype", s1);
            map1.put("filename", s);
            if (s.contains("_")) {
                String s2 = s.split("_")[0];
                Long aLong = Long.valueOf(s2);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format1 = format.format(aLong);
                map1.put("datetime", format1);
            } else {
                map1.put("datetime", new Date());
            }

            list.add(map1);
        }

        map.put("moveup_dir_path", "");
        map.put("current_dir_path", "");
        //获取当前网站的协议名
        String scheme = request.getScheme();
        //获取本机IP地址
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        //获取端口号
        int port = request.getServerPort();
        //获取项目名
        String path = request.getContextPath();
        String url = scheme + "://" + hostAddress + ":" + port + path + "/img/";
        map.put("current_url", url);
        int size = list.size();
        map.put("total_count", size);
        map.put("file_list", list);
        return map;
    }
}
