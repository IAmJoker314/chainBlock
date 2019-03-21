package com.wxiip.service.impl;

import com.wxiip.mapper.UserMapper;
import com.wxiip.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: dell
 * @date: 2019-03-21 9:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void addUser() {

    }
}
