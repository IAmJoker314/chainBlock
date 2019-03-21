package com.wxiip.service;

import com.wxiip.ebusdomain.BatteryDataparseInfo;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月08日  09：13
 * @Description:
 */
public interface BatteryDataparseService {
    List<BatteryDataparseInfo> queryChargeOfVehicle(String vin,String startime,String endtime);
}
