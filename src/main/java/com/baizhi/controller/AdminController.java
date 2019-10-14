package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @ResponseBody
    @RequestMapping("/login")
    public Map<String, Object> login(String userName, String password, HttpSession session, String enCode) {
        Map<String, Object> login = adminService.login(userName, password, enCode, session);
        return login;
    }
}
