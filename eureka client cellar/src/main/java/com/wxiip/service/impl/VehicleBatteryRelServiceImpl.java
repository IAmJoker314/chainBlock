package com.wxiip.service.impl;

import com.wxiip.mapper.VehicleBatteryRelMapper;
import com.wxiip.pocdomain.VehicleBatteryRel;
import com.wxiip.service.VehicleBatteryRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: dell
 * @date: 2019-03-20 10:06
 */
@Service
public class VehicleBatteryRelServiceImpl implements VehicleBatteryRelService {

    @Resource
    VehicleBatteryRelMapper vehicleBatteryRelMapper;

    @Override
    public List<VehicleBatteryRel> queryVehicleBatteryRel(VehicleBatteryRel vo) {
        return vehicleBatteryRelMapper.query(vo);
    }
}
