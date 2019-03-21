package com.wxiip.controller;

import com.wxiip.pocdomain.*;
import com.wxiip.service.BatteryChargeHistoryService;
import com.wxiip.service.BatteryInfoService;
import com.wxiip.service.VehicleChargeInfoService;
import com.wxiip.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月07日  08：24
 * @Description: 获取测试车辆信息
 */
@RestController
@RequestMapping("vehicle")
public class VehicleInfoController {
    @Resource
    VehicleInfoService vehicleInfoService;
    @Resource
    VehicleChargeInfoService vehicleChargeInfoService;
    @Autowired
    BatteryInfoService batteryInfoService;
    @Autowired
    BatteryChargeHistoryService batteryChargeHistoryService;

    @RequestMapping(value="/getAllVins",method= RequestMethod.POST)
    public List<VehicleInfo> findAllTestVehicleInfo(){
        List<VehicleInfo> listV=vehicleInfoService.queryAllVehicleInfo();
        return listV;
    }

    @RequestMapping(value="/saveVehicleCharge",method=RequestMethod.POST)
    public int saveVehicleChargeInfo(@RequestBody VehicleChargeInfo cInfo){
        Integer result=vehicleChargeInfoService.saveVehicleChargeInfo(cInfo);
        return result;
    }

    @RequestMapping(value="/getMultiVCharge",method=RequestMethod.POST)
    public int saveMultiVehicleChargeInfo(@RequestBody List<VehicleChargeInfo> listV){
        Integer result=vehicleChargeInfoService.saveMultiVehicleChargeInfo(listV);
        return result;
    }

    @RequestMapping(value="/getBattery",method=RequestMethod.POST)
    public List<BatteryInfo> queryBatteryInfoByVin(@RequestParam("vin") String vin){
        List<BatteryInfo> listB=batteryInfoService.queryBatteryInfoByVin(vin);
        return listB;
    }

    @RequestMapping(value="/saveSingleBChargeInfo",method=RequestMethod.POST)
    public int saveSingleBatteryCharge(@RequestBody BatteryChargeHistory batteryChargeHistory){
        Integer result=batteryChargeHistoryService.saveSingleBatteryCharge(batteryChargeHistory);
        return  result;
    }

    @RequestMapping(value="saveMultiBChargeInfo",method=RequestMethod.POST)
    public int saveMultipleBatteryCharge(@RequestBody List<BatteryChargeHistory> listB){
        Integer result=batteryChargeHistoryService.saveMultipleBatteryCharge(listB);
        return result;
    }
}
