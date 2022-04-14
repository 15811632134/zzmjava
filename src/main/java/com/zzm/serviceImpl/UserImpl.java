package com.zzm.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzm.domain.User;
import com.zzm.dto.UserDto;
import com.zzm.mapper.UserMapper;
import com.zzm.service.UserService;
import com.zzm.utils.ProUtils;
import com.zzm.utils.ValidEnum;
import com.zzm.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User add(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user, ProUtils.getNullPropertyNames(userDto));
        userMapper.insertSelective(user);
        return user;
    }

    public PageInfo getList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAll();
        return new PageInfo<>(list);
    }

    public UserVO selectByImageId(Long id) {
        UserVO userVO = userMapper.selectByImageId(id);
        return userVO;
    }

    public void deleteUser(int id) {
        User user = new User();
        user.setId(id);
        user.setStatus(ValidEnum.UN_VALID.getCode());
        userMapper.updateByPrimaryKeySelective(user);


    }
}
