//package com.zzm.utils;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.BoundHashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//
//import java.io.Serializable;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class MyConfigRedisTemplateTest {
//
//    @Autowired
//    private RedisTemplate redisTemplate; //在MyRedisConfig文件中配置了redisTemplate的序列化之后， 客户端也能正确显示键值对了
//
//
//    public void test(){
//        redisTemplate.opsForValue().set("wujinxing", "lige");
//        System.out.println(redisTemplate.opsForValue().get("wujinxing"));
//        Map<String, Object> map = new HashMap<>();
//        for (int i=0; i<10; i++){
//            User user = new User();
//            user.setId(i);
//            user.setName(String.format("测试%d", i));
//            user.setAge(i+10);
//            map.put(String.valueOf(i),user);
//        }
//        redisTemplate.opsForHash().putAll("测试", map);
//        BoundHashOperations hashOps = redisTemplate.boundHashOps("测试");
//        Map map1 = hashOps.entries();
//        System.out.println(map1);
//    }
//    static class User implements Serializable {
//        private int id;
//        private String name;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public long getAge() {
//            return age;
//        }
//
//        public void setAge(long age) {
//            this.age = age;
//        }
//
//        private long age;
//    }
//}