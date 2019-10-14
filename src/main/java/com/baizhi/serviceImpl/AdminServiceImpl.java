package com.baizhi.serviceImpl;

import com.baizhi.entity.Admin;
import com.baizhi.mapper.AdminMapper;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> login(String userName, String password, String code, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String code1 = (String) session.getAttribute("code");
        if (code1.equals(code)) {
            Admin admin = adminMapper.select(userName);
            session.setAttribute("userName", userName);
            if (admin != null) {
                if (password.equals(admin.getPassword())) {
                    map.put("message", "ok");
                    return map;
                } else {
                    map.put("message", "密码不正确");
                    return map;
                }
            } else {
                map.put("message", "此用户不存在");
                return map;
            }
        } else {
            map.put("message", "验证码错误");
            return map;
        }
    }
}
