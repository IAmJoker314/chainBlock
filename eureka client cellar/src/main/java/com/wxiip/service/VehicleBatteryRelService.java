package com.wxiip.service;

import com.wxiip.pocdomain.VehicleBatteryRel;

import java.util.List;

/**
 * @description:
 * @author: dell
 * @date: 2019-03-20 9:53
 */
public interface VehicleBatteryRelService {

    /**查询车辆电池关联信息**/
    List<VehicleBatteryRel> queryVehicleBatteryRel(VehicleBatteryRel vo);
}
