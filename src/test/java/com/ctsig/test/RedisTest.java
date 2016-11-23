package com.ctsig.test;

import com.ctsig.test.domain.User2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version： V1.0.0
 * @des：
 * @author: Shen
 * @email: shenzhaoxiang@gmail.com
 * @date: 2016/11/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class RedisTest {
    @Autowired
    private RedisTemplate<String, User2> redisTemplate;
    @Test
    public void test() throws Exception {
        // 保存对象
        User2 user2 = new User2("1", 20);
        redisTemplate.opsForValue().set(user2.getUsername(), user2);
        user2 = new User2("2", 30);
        redisTemplate.opsForValue().set(user2.getUsername(), user2);
        user2 = new User2("3", 40);
        redisTemplate.opsForValue().set(user2.getUsername(), user2);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("1").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("2").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("3").getAge().longValue());
    }
}
