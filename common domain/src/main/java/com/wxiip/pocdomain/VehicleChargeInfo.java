package com.wxiip.pocdomain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  14：15
 * @Description: 测试车辆充电信息表
 */
public class VehicleChargeInfo implements Serializable {

    private static final long serialVersionUID = 2866252809838921258L;
    /**
     * 自增主键ID
     */
    private BigInteger id;
    /**
     * 车辆vin
     */
    private String vin;
    /**
     * 一段时间内充电次数
     */
    private Integer chargeTime1;
    /**
     * 一段时间内充电值
     */
    private Double chargeTime2;
    /**
     * 统计充电的确切时间
     */
    private Timestamp creatime;
    /**
     * 统计状态,1统计到剩余价值，0还没有
     */
    private String sflag;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getChargeTime1() {
        return chargeTime1;
    }

    public void setChargeTime1(Integer chargeTime1) {
        this.chargeTime1 = chargeTime1;
    }

    public Double getChargeTime2() {
        return chargeTime2;
    }

    public void setChargeTime2(Double chargeTime2) {
        this.chargeTime2 = chargeTime2;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

    public String getSflag() {
        return sflag;
    }

    public void setSflag(String sflag) {
        this.sflag = sflag;
    }
}
