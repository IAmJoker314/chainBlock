package com.wxiip.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wxiip.ebusdomain.BatteryDataparseInfo;
import com.wxiip.pocdomain.BatteryChargeHistory;
import com.wxiip.pocdomain.BatteryInfo;
import com.wxiip.pocdomain.VehicleChargeInfo;
import com.wxiip.pocdomain.VehicleInfo;
import com.wxiip.service.BatteryDataparseFeignClent;
import com.wxiip.service.UserFeignClient;
import com.wxiip.service.VehicleFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: dell
 * @date: 2019-02-28 16:47
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserFeignClient userFeignClient;
    @Resource
    VehicleFeignClient vehicleFeignClient;
    @Resource
    BatteryDataparseFeignClent batteryDataparseFeignClent;
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public Map getUser(){
        Map map = userFeignClient.findById(1L);
        return map;
    }

    @RequestMapping(value="/getVehicles",method=RequestMethod.POST)
    public void getVehicleInfo(){
        try{
            Calendar cal=Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String endtime=sdf.format(cal.getTime());
            cal.add(Calendar.DATE,-25);
            String startime=sdf.format(cal.getTime());
            List<VehicleInfo> listV=vehicleFeignClient.findAllTestVehicleInfo(); //查询测试车辆信息
            int totalV=0;
            int startV=0,endV=0;
            int result=0;
            double consumption=0;
            VehicleInfo vInfo;
            BatteryDataparseInfo bInfo;
            VehicleChargeInfo vChargeInfo=null;
            BatteryInfo batteryInfo;
            BatteryChargeHistory batteryChargeHistory=null;
//            List<BatteryChargeHistory> listBCH=new ArrayList<>();
//            List<VehicleChargeInfo> listVCI=new ArrayList<>();
            for(int i=0;i<listV.size();i++){
                vInfo=listV.get(i);
                consumption = vInfo.getChargetimes();
                List<BatteryDataparseInfo> listB=batteryDataparseFeignClent.queryChargeOfVehicle(vInfo.getVin(),startime,endtime); //查询车辆充电信息，统计固定时间段的充电量
                for(int j=0;j<listB.size();j++){
                    bInfo=listB.get(j);
                    if(j==0){
                        startV=Integer.parseInt(bInfo.getSoc());
                    }
                    if(startV > Integer.parseInt(bInfo.getSoc()) && endV==0){
                        startV=Integer.parseInt(bInfo.getSoc());
                    }else if(startV < Integer.parseInt(bInfo.getSoc()) && endV< Integer.parseInt(bInfo.getSoc())){
                        endV=Integer.parseInt(bInfo.getSoc());
                    }else if(endV> Integer.parseInt(bInfo.getSoc()) || (startV<Integer.parseInt(bInfo.getSoc()) && endV==100)){
                        totalV += endV-startV;
                        endV=0;
                        startV=Integer.parseInt(bInfo.getSoc());
                    }
//                    System.out.println(bInfo.getId()+":"+bInfo.getVin()+":"+bInfo.getSoc()+"----j:"+j+"---startV:"+startV+"---endV:"+endV+"----totalV："+totalV);
                }
                if(endV>startV){
                    totalV += endV-startV;
                }
                startV=0;
                endV=0;
                if(totalV>0){
                    vChargeInfo=new VehicleChargeInfo();
                    vChargeInfo.setVin(vInfo.getVin());
                    vChargeInfo.setChargeTime2(totalV*0.01);
                    vChargeInfo.setCreatime(new Timestamp(System.currentTimeMillis()));
                    vChargeInfo.setSflag("0");
                    System.out.println(JSON.toJSONString(vChargeInfo));
                    consumption += totalV*0.01;
                    totalV=0;
//                    listVCI.add(vChargeInfo);
                    result=vehicleFeignClient.saveVehicleChargeInfo(vChargeInfo); //把统计的单辆车充电信息存入车辆充电信息表

                    List<BatteryInfo> listBi=vehicleFeignClient.queryBatteryInfoByVin(vInfo.getVin());
//                listBCH=new ArrayList<>();
                    for(int j=0;j<listBi.size();j++){
                        batteryInfo=listBi.get(j);
                        batteryChargeHistory=new BatteryChargeHistory();
                        batteryChargeHistory.setModuleId(batteryInfo.getModuleId());
                        batteryChargeHistory.setRemainingChargetime1(batteryInfo.getOriginalChargeTimes()-consumption);
                        batteryChargeHistory.setStatisticsTime(new Timestamp(System.currentTimeMillis()));
//                    listBCH.add(batteryChargeHistory);
                        result = vehicleFeignClient.saveSingleBatteryCharge(batteryChargeHistory);//保存单个模组剩余价值信息
                        System.out.println("vin:"+vInfo.getVin()+";module:"+batteryInfo.getModuleId()+";result:"+result);
                    }
                }


//                result=vehicleFeignClient.saveMultipleBatteryCharge(listBCH);  //保存多个模组剩余价值信息
//                System.out.println(";result:"+result);
//                System.out.println(vInfo.getVin());
            }
//            if(listVCI.size()>0){
//                result=vehicleFeignClient.saveMultiVehicleChargeInfo(listVCI);  //保存多辆车充电信息
//                System.out.println(";result:"+result);
//            }
        }catch(Exception e){
            logger.info("保存车辆充电信息过程出现错误",e);
        }
    }

}
