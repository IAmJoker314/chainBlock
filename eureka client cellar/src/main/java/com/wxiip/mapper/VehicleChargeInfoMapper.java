package com.wxiip.mapper;

import com.wxiip.pocdomain.VehicleChargeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月11日  13：03
 * @Description:
 */
@Mapper
@Repository
public interface VehicleChargeInfoMapper {
    /**
     * 保存单辆车辆充电信息
     * @param vChargeInfo
     */
    int saveVehicleChargeInfo(VehicleChargeInfo vChargeInfo);

    /**
     * 保存多辆车辆充电信息
     * @param listC
     * @return
     */
    int saveMultiVehicleChargeInfo(@Param(value="list") List<VehicleChargeInfo> listV);

    List<VehicleChargeInfo> query(VehicleChargeInfo vo);
}
