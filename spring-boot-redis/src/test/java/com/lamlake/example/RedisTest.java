package com.lamlake.example;

import com.lamlake.example.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private RedisConnectionFactory factory;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        RedisConnection connection = factory.getConnection();
        connection.set("hello".getBytes(), "world".getBytes());
        System.out.println("data --> " + new String(connection.get("hello".getBytes())));

    }

    @Test
    public void testRedisTemplate() {
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().append("key1", "value2");
        System.out.println(redisTemplate.opsForValue().get("key1"));
    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("ksy11", "value11");
        System.out.println("ksy11 --> " +  stringRedisTemplate.opsForValue().get("ksy11"));
        System.out.println("key1 --> " +  stringRedisTemplate.opsForValue().get("key1"));
    }

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println("aaa -> " + stringRedisTemplate.opsForValue().get("aaa"));
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        operations.set("com.lamlake", 999);
        operations.set("com.lamlake.test", "999");
        User user = new User(1, "lamlake", "备注");
        operations.set("com.lamlake.user", user);
        Thread.sleep(1000);
        boolean exists=redisTemplate.hasKey("com.lamlake");
        System.out.println(redisTemplate.opsForValue().get("com.lamlake.user"));
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }

}
