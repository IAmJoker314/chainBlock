package com.wxiip.mapper;

import com.wxiip.pocdomain.VehicleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月06日  16：35
 * @Description:
 */
@Mapper
@Repository
public interface VehicleInfoMapper {
    /**
     * 查询所有测试车辆
     * @return
     */
    List<VehicleInfo> queryAllVehicleInfo();
}
