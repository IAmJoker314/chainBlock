package com.wxiip.mapper;

import com.wxiip.pocdomain.VehicleBatteryRel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @author: dell
 * @date: 2019-03-19 17:15
 */
@Mapper
public interface VehicleBatteryRelMapper {

    /**查询**/
    List<VehicleBatteryRel> query(VehicleBatteryRel vo);
}
