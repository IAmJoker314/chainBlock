package com.wxiip.mapper;

import com.wxiip.pocdomain.BatteryChargeHistory;
import com.wxiip.pocdomain.BatteryInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  16：48
 * @Description:
 */
@Mapper
public interface BatteryInfoMapper {
    /**
     * 根据车辆vin查询车辆中模组
     * @param vin
     * @return
     */
    List<BatteryInfo> queryBatteryInfoByVin(String vin);

    /**
     * 查询电池组列表
     * @param vo
     * @return
     */
    List<BatteryInfo> query(BatteryInfo vo);

    /**
     * 查询电池充放电信息
     * @param batteryChargeHistory
     * @return
     */
    List<BatteryChargeHistory> query(BatteryChargeHistory batteryChargeHistory);

    /**
     * 查询电池组列表总记录数
     * @param vo
     * @return
     */
    int queryTotalNumbers(BatteryInfo vo);

    void update(BatteryInfo vo);
}
