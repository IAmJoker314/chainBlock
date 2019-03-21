package com.wxiip.ebusdomain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author: wxciv
 * @Date: 2019年03月08日  08：41
 * @Description:
 */
public class BatteryDataparseInfo implements Serializable {
    private static final long serialVersionUID = 918926311176192115L;
    /**
     * 自增主键
     */
    private BigInteger id;
    /**
     * 车辆vin
     */
    private String vin;
    /**
     * 充电状态
     */
    private String chargeState;
    /**
     * SOC
     */
    private String soc;
    /**
     * 数据采集时间
     */
    private Timestamp collectionTime;

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

    public String getChargeState() {
        return chargeState;
    }

    public void setChargeState(String chargeState) {
        this.chargeState = chargeState;
    }

    public String getSoc() {
        return soc;
    }

    public void setSoc(String soc) {
        this.soc = soc;
    }

    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectionTime) {
        this.collectionTime = collectionTime;
    }
}
