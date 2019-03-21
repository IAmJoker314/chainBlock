package com.wxiip.service;

import com.wxiip.pocdomain.VehicleChargeInfo;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月11日  13：05
 * @Description:
 */
public interface VehicleChargeInfoService {

    int saveVehicleChargeInfo(VehicleChargeInfo vChargeInfo);

    int saveMultiVehicleChargeInfo(List<VehicleChargeInfo> listV);

    List<VehicleChargeInfo> queryVehicleChargeInfo(VehicleChargeInfo vo);
}
