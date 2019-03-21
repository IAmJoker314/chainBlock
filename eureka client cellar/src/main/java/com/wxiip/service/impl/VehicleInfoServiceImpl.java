package com.wxiip.service.impl;

import com.wxiip.mapper.VehicleInfoMapper;
import com.wxiip.pocdomain.VehicleInfo;
import com.wxiip.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月07日  08：22
 * @Description:
 */
@Service
public class VehicleInfoServiceImpl implements VehicleInfoService {
    @Resource
    VehicleInfoMapper vehicleInfoMapper;
    public List<VehicleInfo> queryAllVehicleInfo(){
        List<VehicleInfo> listV=vehicleInfoMapper.queryAllVehicleInfo();
        return listV;
    }

}
