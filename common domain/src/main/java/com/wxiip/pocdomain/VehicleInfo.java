package com.wxiip.pocdomain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  13：57
 * @Description: 要测试的车辆实体类
 */
public class VehicleInfo implements Serializable {

    private static final long serialVersionUID = 4557848930834471405L;
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 车辆vin
     */
    private String vin;
    /**
     * 投入使用时间
     */
    private Timestamp serviceLife;
    /**
     * 已经充了多少次电
     */
    private Integer chargetimes;
    /**
     * 信息生成时间
     */
    private Timestamp creatime;

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

    public Timestamp getServiceLife() {
        return serviceLife;
    }

    public void setServiceLife(Timestamp serviceLife) {
        this.serviceLife = serviceLife;
    }

    public Integer getChargetimes() {
        return chargetimes;
    }

    public void setChargetimes(Integer chargetimes) {
        this.chargetimes = chargetimes;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }
}
