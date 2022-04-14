package com.zzm.controller;


import com.github.pagehelper.PageInfo;
import com.zzm.config.JwtUtils;
import com.zzm.constant.AliyunFilePath;
import com.zzm.constant.TokenConstant;
import com.zzm.domain.Images;
import com.zzm.domain.User;
import com.zzm.dto.UserDto;
import com.zzm.exception.BizExceptionEnum;
import com.zzm.service.ImagesService;
import com.zzm.service.UserService;
import com.zzm.utils.*;
import com.zzm.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
//import javax.ws.rs.*;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.SecurityContext;
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    AliyunOSSUtil aliyunOSSUtil;

    @Autowired
    UserService userService;

    @Autowired
    ImagesService imagesService;

    @Autowired
    private RedisTemplate<String, Object> template;

    public static JedisPool jedisPool; // 池化管理jedis链接池

    @RequestMapping(value = "/selectByUserId", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有用户1")
    public UserVO selectByUserId(@ApiParam(name = "id", value = "id", required = true) @RequestParam(required = true) Long id ) {
        UserVO uservo = userService.selectByImageId(id);
        return uservo;
    }

//    @Context
//    ServletContext context;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有用户")
    public Map selectAll(@ApiParam(name = "name", value = "姓名", required = true) @RequestParam(required = true) String name ) {
        /* 设置这个token的生命时间 */
        /* 3650天的有效日期 */
        ValueOperations<String, Object> redisString = template.opsForValue();

        Date expiry = DateUtil.getExpiryDate(TokenConstant.expiry3650DateUnitMinute);
        String token = JwtUtils.getJWTString("15811632134");
        log.info("token+++"+token);
        Map map2 = JwtUtils.getInfo(token);
        log.info("map2:"+map2);
//        Key key = new Ke
//        String token2 = JwtUtils.getName(token, "123123");
        Map map = new HashMap();
        System.out.print(name);
        PageInfo users = userService.getList(1,2);
        log.info("1231232135");
        map.put("users",users);
        map.put("size",10);
        redisUtil.set("users",users);
        System.out.println("------>{}"+redisUtil.get("users"));

        return map;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有用户")
    public ResultDTO delete(@ApiParam(name = "id", value = "姓名", required = true) int id ) {
        userService.deleteUser(id);
        return ResultUtils.messages(BizExceptionEnum.SUCCESS, null);
    }


    @RequestMapping(value = "/insertImage", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "添加用户头像")
    public ResultDTO add(
                         @ApiParam(name = "file", value = "图片（482*646）", required = true) @RequestParam("file")
                                 MultipartFile file) {
        try {

            String startImg1 = aliyunOSSUtil.upload(file, AliyunFilePath.START_IMG_PATH);
            Images images = new Images();
            images.setFilePath(startImg1);
            Images image = imagesService.add(images);

            UserDto user = new UserDto();
            user.setName("默认");
            user.setImage_id(image.getId());

            userService.add(user);
            return ResultUtils.messages(BizExceptionEnum.SUCCESS, null);
        } catch (Exception e) {
            return ResultUtils.messages(BizExceptionEnum.ERROR, null);
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public User insertUser(@ApiParam(name = "name", value = "姓名", required = true) UserDto userDto) throws IOException {
//        1. 读取mybatis配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
////　　　　2.创建SqlSessionFactory的构建者对象
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
////　　　　3.使用构建者创建工厂对象SqlSessionFactory
//        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(in);
////　　　　4.使用SqlSessionFactory生产SqlSession对象
//        SqlSession sqlSession = sessionFactory.openSession();
////　　　　5.使用SqlSession生产代理对象
//        UserService userDao = sqlSession.getMapper(UserService.class);
////　　　　6.使用代理对象执行方法
////        List<User> users = userDao.findAlls(1);
////        for (User user : users) {
////            System.out.println(user.getId());
////            System.out.println(user.getName());
////            System.out.println(JSONArray.toJSON(user));
////        }
        User user = userService.add(userDto);
//        userDao.insert(u);
//        sqlSession.commit();
//　　　　7.释放资源
//        in.close();
//        sqlSession.close();
//        str = name;
//        Map<String,Object> map = new HashMap();
//        map.put("code",100);
//        map.put("data","");
//        map.put("message","ok");
        return user;
    }
}
