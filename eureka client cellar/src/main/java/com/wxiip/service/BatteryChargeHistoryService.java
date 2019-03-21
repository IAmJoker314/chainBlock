package com.wxiip.service;

import com.wxiip.pocdomain.BatteryChargeHistory;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月12日  15：43
 * @Description:
 */
public interface BatteryChargeHistoryService {

    int saveSingleBatteryCharge(BatteryChargeHistory batteryChargeHistory);

    int saveMultipleBatteryCharge(List<BatteryChargeHistory> listB);

    List<BatteryChargeHistory> queryBatteryChargeHistory(BatteryChargeHistory vo);
}
