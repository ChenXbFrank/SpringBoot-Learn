package com.cxb.controller.Redis;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cxb.model.User;
import com.cxb.service.IRedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired  
    private IRedisService redisService;  

    //http://localhost:8888/helloSpringBoot/redis/set?key=msm&value=mm
    @RequestMapping("/set")  
    public boolean redisSet(@RequestParam("key")String key, @RequestParam("value")String value){  
        boolean isOk = redisService.set(key, value);  
        return isOk;  
    }  
      
    // http://localhost:8888/helloSpringBoot/redis/get?key=cxb
    @RequestMapping("/get")  
    public String redisGet(String key){  
        String name = redisService.get(key);  
        return name;  
    }  

    @RequestMapping("/hello")
	public String hello() {
		return "Hello Rdeis !";
	}
    
  //保存对象
    @Autowired
    private RedisTemplate<Object, User> redisTemplate;

    @RequestMapping("/test1")
    public String test1() throws Exception {
        // 保存对象
        User user = new User("1","超人", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("2","蝙蝠侠", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);

        user = new User("3","蜘蛛侠", new Date());
        redisTemplate.opsForValue().set(user.getUserName(), user);
        return "保存对象成功！";
    }
}
