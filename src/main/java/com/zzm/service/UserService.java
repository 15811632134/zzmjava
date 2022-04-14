package com.zzm.service;

import com.github.pagehelper.PageInfo;
import com.zzm.domain.User;
import com.zzm.dto.UserDto;
import com.zzm.vo.UserVO;

public interface UserService {
    User add(UserDto userDto);
    PageInfo getList(int pageNum, int pageSize );
    void  deleteUser(int id);
    UserVO selectByImageId(Long companyId);
}
