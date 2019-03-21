package com.wxiip.service.impl;

import com.wxiip.mapper.VehicleChargeInfoMapper;
import com.wxiip.pocdomain.VehicleChargeInfo;
import com.wxiip.service.VehicleChargeInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月11日  13：06
 * @Description:
 */
@Service
public class VehicleChargeInfoServiceImpl implements VehicleChargeInfoService {

    @Resource
    VehicleChargeInfoMapper vehicleChargeInfoMapper;

    public int saveVehicleChargeInfo(VehicleChargeInfo vChargeInfo){
        return vehicleChargeInfoMapper.saveVehicleChargeInfo(vChargeInfo);
    }

    @Override
    public int saveMultiVehicleChargeInfo(List<VehicleChargeInfo> listV) {
        return vehicleChargeInfoMapper.saveMultiVehicleChargeInfo(listV);
    }

    @Override
    public List<VehicleChargeInfo> queryVehicleChargeInfo(VehicleChargeInfo vo) {
        return vehicleChargeInfoMapper.query(vo);
    }
}
