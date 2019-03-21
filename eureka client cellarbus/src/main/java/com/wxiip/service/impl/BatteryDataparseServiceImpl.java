package com.wxiip.service.impl;

import com.wxiip.ebusdomain.BatteryDataparseInfo;
import com.wxiip.mapper.BatteryDataparseMapper;
import com.wxiip.service.BatteryDataparseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月08日  09：14
 * @Description:
 */
@Service
public class BatteryDataparseServiceImpl implements BatteryDataparseService {
    @Autowired
    BatteryDataparseMapper batteryDataparseMapper;

    public List<BatteryDataparseInfo> queryChargeOfVehicle(String vin,String startime,String endtime){
        return batteryDataparseMapper.queryChargeOfVehicle(vin,startime,endtime);
    }
}
