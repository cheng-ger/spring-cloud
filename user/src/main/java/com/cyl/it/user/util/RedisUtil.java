package com.cyl.it.user.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate redisTemplate ;


    //ttl key 可以看过期时间  以秒为单位

    public Long  ttl(String key){


        return redisTemplate.getExpire(key);
    }

    //设置过期时间

    public void expire(String key , long time){
        redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 实现命令：INCR key，增加key一次
     */

    public long incr(String key, long delta) {

        return redisTemplate.opsForValue().increment(key, delta);

    }

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     */

    public Set<String> keys(String pattern) {

        return redisTemplate.keys(pattern);

    }

    /**
     * 实现命令：DEL key，删除一个key
     */

    public void del(String key) {

        redisTemplate.delete(key);

    }

    // String（字符串）

    /**
     * 实现命令：SET key value，设置一个key-value（将字符串值 value关联到 key）
     */

    public void set(String key, String value) {

        redisTemplate.opsForValue().set(key, value);

    }

    /**
     * 实现命令：SET key value EX seconds，设置key-value和超时时间（秒）
     */

    public void set(String key, String value, long timeout) {

        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);

    }

    /**
     * 实现命令：GET key，返回 key所关联的字符串值。
     */

    public String get(String key) {

        return redisTemplate.opsForValue().get(key);

    }
    // Hash（哈希表）


    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     */
    public void hset(String key, String field, Object value) {

        redisTemplate.opsForHash().put(key, field, value);

    }

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     */

    public String hget(String key, String field) {

        return (String) redisTemplate.opsForHash().get(key, field);

    }

    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     */

    public void hdel(String key, Object... fields) {

        redisTemplate.opsForHash().delete(key, fields);

    }

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     */
    public Map<Object, Object> hgetall(String key) {

        return redisTemplate.opsForHash().entries(key);

    }

    // List（列表）

    /**
     * 实现命令：LPUSH key value，将一个值 value插入到列表 key的表头
     */
    public long lpush(String key, String value) {

        return redisTemplate.opsForList().leftPush(key, value);

    }

    /**
     * 实现命令：LPOP key，移除并返回列表 key的头元素。
     */

    public String lpop(String key) {

        return  redisTemplate.opsForList().leftPop(key);

    }



    /**
     * 实现命令：RPUSH key value，将一个值 value插入到列表 key的表尾(最右边)。
     */

    public long rpush(String key, String value) {

        return redisTemplate.opsForList().rightPush(key, value);

    }

}
