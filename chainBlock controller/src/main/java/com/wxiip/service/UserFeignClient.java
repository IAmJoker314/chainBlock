package com.wxiip.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @description:
 * @author: dell
 * @date: 2019-02-28 15:31
 */

@FeignClient(name = "user-service")
public interface UserFeignClient {
    @RequestMapping(value = "/provider/getUser/{id}", method = RequestMethod.POST)
    Map findById(@PathVariable("id") Long id);
}
