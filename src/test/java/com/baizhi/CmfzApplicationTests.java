package com.baizhi;

import com.baizhi.mapper.EchartsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    EchartsMapper userMapper;

    @Test
    public void select() {
        System.out.println();
        System.out.println("asd");
        System.out.println("lll");
    }
}
