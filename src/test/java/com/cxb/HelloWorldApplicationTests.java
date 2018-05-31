package com.cxb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cxb.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	
    @Test
    public void test() throws Exception {
        List<String> list =new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("v");
        stringRedisTemplate.opsForValue().set("abc", "测试");
        stringRedisTemplate.opsForList().leftPushAll("qq",list); // 向redis存入List
        stringRedisTemplate.opsForList().range("qwe",0,-1).forEach(value ->{
           System.out.println(value);
        });
    }
    
    //保存对象
    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test1() throws Exception {

        // 保存对象
        User user = new User("1","超人", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("2","蝙蝠侠", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("3","蜘蛛侠", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);
    }

}
