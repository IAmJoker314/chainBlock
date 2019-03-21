package com.wxiip.service.impl;

import com.wxiip.mapper.BatteryInfoMapper;
import com.wxiip.mapper.UserLandMapper;
import com.wxiip.pocdomain.User;
import com.wxiip.service.UserLandService;

import javax.annotation.Resource;

public class UserLandServicelmpl implements UserLandService {
    @Resource
    UserLandMapper userLandMapper;
    @Override
    public boolean checkUser(User user) {
        User sqlUser = userLandMapper.getUserInfo(user.getUserName());
        return sqlUser.getPassword().equals(user.getPassword());
    }
}
