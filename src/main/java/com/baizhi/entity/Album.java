package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String id;
    private String title;//标题
    private String cover;//封面路径
    private Double score;//评分
    private String author;//作者
    private String beam;//播音员
    private Integer count;//章节数
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createDate;//上传时间
    private String content;//简介
    private String status;
}
