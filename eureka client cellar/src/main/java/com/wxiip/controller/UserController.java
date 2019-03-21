package com.wxiip.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: dell
 * @date: 2019-02-28 15:49
 */
@RestController
@RequestMapping("provider")
public class UserController {
    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.POST)
    public Map getUser(@PathVariable("id") Integer id){
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        return map;
    }
}
