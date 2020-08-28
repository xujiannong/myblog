package com.lan.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: myblog
 * @description:
 * @author: xujiannong
 * @create: 2020-07-03 10:42
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApplication.class)//项目启动类
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void getRedisName() {
        redisTemplate.opsForValue().get("aaa");
        stringRedisTemplate.opsForValue().get("aaa");
    }

    @Test
    public void setRedis() {
        redisTemplate.opsForValue();
    }
}
