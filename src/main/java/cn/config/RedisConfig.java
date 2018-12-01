///**
// * Copyright (C), 2015-2018, XXX有限公司
// * FileName: RedisConfig
// * Author:   13654
// * Date:     2018/12/1 14:10
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package cn.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//
///**
// * 功能描述: <br>
// * 〈集群序列化〉
// *
// * @param null
// * @return:
// * @since: 1.0.0
// * @Author:13654
// * @Date: 2018/12/1 14:12
// */
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1)); // 设置缓存有效期一小时
//        return RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(redisCacheConfiguration).build();
//    }
//
//
//    /**
//     * 设置 redisTemplate 的序列化设置
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        // 1.创建 redisTemplate 模版
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        // 2.关联 redisConnectionFactory
//        template.setConnectionFactory(redisConnectionFactory);
//        // 3.创建 序列化类
//        //使用Jackson2JsonRedisSerialize 替换默认序列化
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        // 4.设置可见度
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // 5.启动默认的类型
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        // 6.序列化类，对象映射设置
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        // 7.设置 value 的转化格式和 key 的转化格式
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.afterPropertiesSet();
//        return template;
//    }
//}