package com.wxiip.service;

import com.wxiip.pocdomain.BatteryInfo;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月12日  14：09
 * @Description:
 */
public interface BatteryInfoService {
    
    List<BatteryInfo> queryBatteryInfoByVin(String vin);

    List<BatteryInfo> queryBatteryList(BatteryInfo vo);

    int queryBatteryTotalNumbers(BatteryInfo vo);

    void updateBatteryInfo(BatteryInfo vo);
}
