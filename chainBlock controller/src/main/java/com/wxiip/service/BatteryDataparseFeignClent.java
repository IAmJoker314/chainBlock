package com.wxiip.service;

import com.wxiip.ebusdomain.BatteryDataparseInfo;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月08日  10：02
 * @Description:
 */
@FeignClient(name="ebus-service")
public interface BatteryDataparseFeignClent {
    @RequestMapping(value="/ebus/getChargeinfo",method= RequestMethod.POST)
    List<BatteryDataparseInfo> queryChargeOfVehicle(@RequestParam("vin") String vin,@RequestParam("startime") String startime,@RequestParam("endtime") String endtime);
}
