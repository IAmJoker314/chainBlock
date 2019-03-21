package com.wxiip.controller;

import com.alibaba.fastjson.JSON;
import com.wxiip.bean.ResponseBean;
import com.wxiip.pocdomain.BatteryInfo;
import com.wxiip.pocdomain.VehicleBatteryRel;
import com.wxiip.pocdomain.VehicleChargeInfo;
import com.wxiip.service.BatteryInfoService;
import com.wxiip.service.VehicleBatteryRelService;
import com.wxiip.service.VehicleChargeInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: dell
 * @date: 2019-03-15 8:56
 */
@RestController
@RequestMapping("cellarInfo")
public class CellarInfoController {

    private static final Logger logger = LoggerFactory.getLogger(CellarInfoController.class);

    @Resource
    BatteryInfoService batteryInfoService;

    @Resource
    VehicleBatteryRelService vehicleBatteryRelService;

    @Resource
    VehicleChargeInfoService vehicleChargeInfoService;

    @RequestMapping(value="/queryCellarInfo",method= RequestMethod.POST)
    public ResponseBean queryCellarInfo(@RequestBody Map<String,Object> map){
        try{
            /**查询实体**/
            BatteryInfo vo = JSON.parseObject(JSON.toJSONString(map),BatteryInfo.class);

            /**设置起始页start**/
            if(vo.getPageSize() != 0 && vo.getCurrentPage() != 0){
                int start = (vo.getCurrentPage() - 1) * vo.getPageSize();
                vo.setStart(start);
            }

            List<BatteryInfo> list = batteryInfoService.queryBatteryList(vo);

            if(!CollectionUtils.isEmpty(list)){
                return new ResponseBean(0,"查询成功",list);
            }else{
                return new ResponseBean(0,"未找到符合条件的数据",list);
            }

        }catch(Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"查询失败",null);
        }
    }

    @RequestMapping(value="/queryCellarChargeHis",method= RequestMethod.POST)
    public ResponseBean queryCellarChargeHis(@RequestBody Map<String,Object> map){
        try{
            String moduleId = "";
            String vin = "";
            List<VehicleChargeInfo> list = new ArrayList<VehicleChargeInfo>();
            /**查询实体**/
            if(map.get("moduleId") != null){
                moduleId = map.get("moduleId").toString();
            }

            VehicleBatteryRel vehicleBatteryRel = new VehicleBatteryRel();
            vehicleBatteryRel.setModuleId(moduleId);

            /**查询电池组与车辆关系**/
            List<VehicleBatteryRel> vehicleBatteryRelList = vehicleBatteryRelService.queryVehicleBatteryRel(vehicleBatteryRel);

            /**获取车辆充电记录**/
            if(!CollectionUtils.isEmpty(vehicleBatteryRelList)){
                vin = vehicleBatteryRelList.get(0).getVin();
            }

            VehicleChargeInfo vo = new VehicleChargeInfo();
            vo.setVin(vin);

            list = vehicleChargeInfoService.queryVehicleChargeInfo(vo);

            if(!CollectionUtils.isEmpty(list)){
                return new ResponseBean(0,"查询成功",list);
            }else{
                return new ResponseBean(0,"未找到符合条件的数据",list);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"查询失败",null);
        }
    }

    @RequestMapping(value="/queryBatteryTotalNumbers",method= RequestMethod.POST)
    public ResponseBean queryBatteryTotalNumbers(@RequestBody Map<String,Object> map){
        try{
            /**查询实体**/
            BatteryInfo vo = JSON.parseObject(JSON.toJSONString(map),BatteryInfo.class);

            int count = batteryInfoService.queryBatteryTotalNumbers(vo);

            return new ResponseBean(0,"查询记录总数成功",count);

        }catch(Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"查询记录总数失败",-1);
        }
    }

    @RequestMapping(value="/transferOwnership",method= RequestMethod.POST)
    public ResponseBean transferOwnership(@RequestBody Map<String,Object> map){
        try{
            String owner = "";
            String moduleId = "";

            if(map.get("moduleId")!= null && map.get("owner") != null){
                owner = map.get("owner").toString();
                moduleId = map.get("moduleId").toString();
            }
            BatteryInfo vo = new BatteryInfo();
            vo.setOwner(owner);
            vo.setModuleId(moduleId);
            batteryInfoService.updateBatteryInfo(vo);

            return new ResponseBean(0,"移交电池所有权成功",null);
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ResponseBean(-1,"移交电池所有权失败",-1);
        }
    }
}
