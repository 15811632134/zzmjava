package com.zzm.mapper;

import com.zzm.domain.User;
import com.zzm.vo.UserVO;
import tk.mybatis.mapper.common.Mapper;


public interface UserMapper extends Mapper<User> {
    UserVO selectByImageId(Long companyId);
}
