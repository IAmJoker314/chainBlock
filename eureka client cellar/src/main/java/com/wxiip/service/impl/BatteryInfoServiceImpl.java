package com.wxiip.service.impl;

import com.wxiip.mapper.BatteryInfoMapper;
import com.wxiip.pocdomain.BatteryInfo;
import com.wxiip.service.BatteryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月12日  14：10
 * @Description:
 */
@Service
public class BatteryInfoServiceImpl implements BatteryInfoService {

    @Resource
    BatteryInfoMapper batteryInfoMapper;

    @Override
    public List<BatteryInfo> queryBatteryInfoByVin(String vin) {
        return batteryInfoMapper.queryBatteryInfoByVin(vin);
    }

    @Override
    public List<BatteryInfo> queryBatteryList(BatteryInfo vo) {
        return batteryInfoMapper.query(vo);
    }

    @Override
    public int queryBatteryTotalNumbers(BatteryInfo vo) {
        return batteryInfoMapper.queryTotalNumbers(vo);
    }

    @Override
    public void updateBatteryInfo(BatteryInfo vo) {
        batteryInfoMapper.update(vo);
    }
}
