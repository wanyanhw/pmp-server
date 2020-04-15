package com.wyhw.pmp.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Autowired
    RedisConnectionFactory connectionFactory;

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        //RedisTemplate会自动初始化StringRedisSerializer,所以这里直接取
        final RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
        //设置字符串序列化器，这样spring就会吧redis的key当做字符串来处理了
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

}
