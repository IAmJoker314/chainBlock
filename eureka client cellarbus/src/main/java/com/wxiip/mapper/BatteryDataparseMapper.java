package com.wxiip.mapper;

import com.wxiip.ebusdomain.BatteryDataparseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: wxciv
 * @Date: 2019年03月08日  08：55
 * @Description:
 */
@Mapper
@Repository
public interface BatteryDataparseMapper {
    /**
     * 查询一辆车在一定时间内的充电信息
     * @return
     */
    List<BatteryDataparseInfo> queryChargeOfVehicle(@Param("vin") String vin,@Param("startime") String startime,@Param("endtime") String endtime);
}
