package com.wxiip.pocdomain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  15：21
 * @Description: 汽车和模组对应实体类
 */
public class VehicleBatteryRel implements Serializable {

    private static final long serialVersionUID = 6264126191403804210L;
    /**
     * 自增主键ID
     */
    private Integer id;
    /**
     * 车辆vin
     */
    private String vin;
    /**
     * 电池模组ID
     */
    private String moduleId;
    /**
     * 模组状态,1正常，0被替换下来
     */
    private String mflag;
    /**
     * 信息生成时间
     */
    private String creatime;
    /**
     * 更新时间
     */
    private String updatime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getMflag() {
        return mflag;
    }

    public void setMflag(String mflag) {
        this.mflag = mflag;
    }

    public String getCreatime() {
        return creatime;
    }

    public void setCreatime(String creatime) {
        this.creatime = creatime;
    }

    public String getUpdatime() {
        return updatime;
    }

    public void setUpdatime(String updatime) {
        this.updatime = updatime;
    }
}
