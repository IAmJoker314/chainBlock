package com.wxiip.controller;

import com.alibaba.fastjson.JSON;
import com.wxiip.bean.ResponseBean;
import com.wxiip.pocdomain.BatteryInfo;
import com.wxiip.pocdomain.User;
import com.wxiip.service.UserLandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("userLand")
public class UserLandController {

    private static final Logger logger = LoggerFactory.getLogger(CellarInfoController.class);

    @Resource
    UserLandService userLandService;

    @RequestMapping(value="/userLand",method= RequestMethod.POST)
    public ResponseBean checkUserLandInfo(@RequestBody Map<String,Object> map){
        try{

            User user = JSON.parseObject(JSON.toJSONString(map),User.class);

            if(user.getUserName() != null && user.getPassword() != null){
                boolean b = userLandService.checkUser(user);

                if(b)
                {
                    return new ResponseBean(0,"验证成功", null);
                }
                else
                {
                    return new ResponseBean(0,"密码或用户名错误", null);
                }

            }
            else
            {
                return new ResponseBean(-1,"请输入密码和用户名",null);
            }

        }catch(Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"验证失败",null);
        }
    }

}
