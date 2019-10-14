package com.baizhi.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
    @ExcelIgnore
    private String id;
    @Excel(name = "标题")
    private String title;
    @Excel(name = "图片", type = 2)
    private String imgPath;
    @Excel(name = "状态")
    private String status;
    @Excel(name = "描述信息")
    private String descc;

    @Excel(name = "创建时间", format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createDate;
}
