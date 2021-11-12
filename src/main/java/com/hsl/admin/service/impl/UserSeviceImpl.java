package com.hsl.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hsl.admin.bean.User;
import com.hsl.admin.mapper.UserMapper;
import com.hsl.admin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
