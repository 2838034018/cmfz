package com.baizhi.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<Banner> selectAll() {
        List<Banner> list = bannerService.selectAll();
        return list;
    }

    @ResponseBody
    @RequestMapping("/selectByPage")
    public Map<String, Object> selectByPage(Integer page, Integer rows) {
        Integer count = bannerService.count();
        Integer total = count % rows == 0 ? count / rows : count / rows + 1;
        List<Banner> banners = bannerService.selectByPage(page, rows);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", banners);
        map.put("records", count);
        map.put("page", page);
        map.put("total", total);
        return map;
    }


    @RequestMapping("/edit")
    public String edit(Banner banner, String oper, String[] id) {
        if (oper.equals("add")) {
            String s = UUID.randomUUID().toString();
            banner.setId(s);
            banner.setCreateDate(new Date());
            bannerService.save(banner);
            return s;
        } else if (oper.equals("del")) {
            bannerService.delete(id);
        } else {
            bannerService.update(banner);
        }
        return null;
    }

    @RequestMapping("/upload")
    public void upload(MultipartFile imgPath, String bannerId, HttpSession session) {
        String realPath = session.getServletContext().getRealPath("/img");

        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String originalFilename = imgPath.getOriginalFilename();
        String newFileName = new Date().getTime() + "_" + originalFilename;
        try {
            imgPath.transferTo(new File(realPath, newFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        bannerService.updateImg(bannerId, newFileName);
    }

    @RequestMapping("/derive")
    public void derive(HttpServletResponse response) throws IOException {
        List<Banner> banners = bannerService.selectAll();
        for (Banner banner : banners) {
            banner.setImgPath("F:\\百知教育\\后期项目\\source\\cmfz\\src\\main\\webapp\\img\\" + banner.getImgPath());
        }
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("轮播图信息", "表1"),
                Banner.class, banners);

        String encode = URLEncoder.encode("轮播图.xls", "UTF-8");
        response.setHeader("content-disposition", "attachment;filename=" + encode);
        ServletOutputStream outputStream = response.getOutputStream();

        workbook.write(outputStream);
    }
}
