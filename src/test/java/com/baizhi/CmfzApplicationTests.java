package com.baizhi;


import com.baizhi.articleRepsitory.ArticleRepsitory;
import com.baizhi.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    ArticleRepsitory articleRepsitory;
    @Test
    public void select() {
        Article article = new Article();
        article.setId("001");
        article.setAuthor("杜甫");
        article.setTitle("大风歌");
        article.setContent("且将新火试新茶,诗酒趁年华");
        article.setCreateDate(new Date());
        articleRepsitory.save(article);
    }
}
