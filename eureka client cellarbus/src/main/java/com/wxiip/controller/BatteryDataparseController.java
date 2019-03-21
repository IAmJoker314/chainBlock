package com.wxiip.controller;

import com.wxiip.ebusdomain.BatteryDataparseInfo;
import com.wxiip.service.BatteryDataparseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月08日  09：17
 * @Description:
 */
@RestController
@RequestMapping("ebus")
public class BatteryDataparseController {
    @Autowired
    BatteryDataparseService batteryDataparseService;
    @RequestMapping(value="/getChargeinfo",method= RequestMethod.POST)
    public List<BatteryDataparseInfo> queryChargeOfVehicle(@RequestParam("vin") String vin,@RequestParam("startime") String startime,@RequestParam("endtime") String endtime){
        List<BatteryDataparseInfo> listB=batteryDataparseService.queryChargeOfVehicle(vin,startime,endtime);
        System.out.println("Batery充电信息已查出");
        return listB;
    }
}
