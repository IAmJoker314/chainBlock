package com.wxiip.mapper;

import com.wxiip.pocdomain.BatteryChargeHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月12日  15：19
 * @Description:
 */
@Mapper
public interface BatteryChargeHistoryMapper {
    /**
     * 保存一条模组充电历史信息
     * @param batteryChargeHistory
     * @return
     */
    int saveSingleBatteryCharge(BatteryChargeHistory batteryChargeHistory);

    /**
     * 批量插入模组充电历史信息
     * @param listB
     */
    int saveMultipleBatteryCharge(@Param(value="list") List<BatteryChargeHistory> listB);

    List<BatteryChargeHistory> query(BatteryChargeHistory batteryChargeHistory);
}
