package com.cxb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.cxb.model.RedisObjectSerializer;
import com.cxb.model.User;

import redis.clients.jedis.JedisPoolConfig;

@Configuration  
@EnableAutoConfiguration  
public class RedisConfig {
      
    @Bean  
    @ConfigurationProperties(prefix="spring.redis")  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        return config;  
    }  
      
    @SuppressWarnings("deprecation")
	@Bean  
    @ConfigurationProperties(prefix="spring.redis")  
    public JedisConnectionFactory getConnectionFactory(){  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        System.out.println("JedisConnectionFactory bean init success.");  
        return factory;  
    }  
      
    @Bean  
    public RedisTemplate<?, ?> getRedisTemplate(){  
    	RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(getConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }  
   
}

