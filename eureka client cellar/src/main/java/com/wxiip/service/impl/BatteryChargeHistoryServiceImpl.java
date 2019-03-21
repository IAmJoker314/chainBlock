package com.wxiip.service.impl;

import com.wxiip.mapper.BatteryChargeHistoryMapper;
import com.wxiip.pocdomain.BatteryChargeHistory;
import com.wxiip.service.BatteryChargeHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月12日  15：44
 * @Description:
 */
@Service
public class BatteryChargeHistoryServiceImpl implements BatteryChargeHistoryService {

    @Resource
    BatteryChargeHistoryMapper batteryChargeHistoryMapper;

    @Override
    public int saveSingleBatteryCharge(BatteryChargeHistory batteryChargeHistory) {
        return batteryChargeHistoryMapper.saveSingleBatteryCharge(batteryChargeHistory);
    }

    @Override
    public int saveMultipleBatteryCharge(List<BatteryChargeHistory> listB) {
        return batteryChargeHistoryMapper.saveMultipleBatteryCharge(listB);
    }

    @Override
    public List<BatteryChargeHistory> queryBatteryChargeHistory(BatteryChargeHistory vo) {
        return batteryChargeHistoryMapper.query(vo);
    }
}
