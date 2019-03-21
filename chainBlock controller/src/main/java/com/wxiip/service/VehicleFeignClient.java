package com.wxiip.service;

import com.wxiip.pocdomain.BatteryChargeHistory;
import com.wxiip.pocdomain.BatteryInfo;
import com.wxiip.pocdomain.VehicleChargeInfo;
import com.wxiip.pocdomain.VehicleInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月07日  09：07
 * @Description:
 */
@FeignClient(name = "user-service")
public interface VehicleFeignClient {
    @RequestMapping(value="/vehicle/getAllVins",method= RequestMethod.POST)
    List<VehicleInfo> findAllTestVehicleInfo();

    @RequestMapping(value="/vehicle/saveVehicleCharge",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    int saveVehicleChargeInfo(@RequestBody VehicleChargeInfo cInfo);

    @RequestMapping(value="/vehicle/getMultiVCharge",method=RequestMethod.POST)
    int saveMultiVehicleChargeInfo(@RequestBody List<VehicleChargeInfo> listV);

    @RequestMapping(value="/vehicle/getBattery",method=RequestMethod.POST)
    List<BatteryInfo> queryBatteryInfoByVin(@RequestParam("vin") String vin);

    @RequestMapping(value="/vehicle/saveSingleBChargeInfo",method=RequestMethod.POST)
    int saveSingleBatteryCharge(@RequestBody BatteryChargeHistory batteryChargeHistory);

    @RequestMapping(value="/vehicle/saveMultiBChargeInfo",method=RequestMethod.POST)
    int saveMultipleBatteryCharge(@RequestBody List<BatteryChargeHistory> listB);
}
