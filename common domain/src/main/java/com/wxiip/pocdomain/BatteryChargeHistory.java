package com.wxiip.pocdomain;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  14：26
 * @Description: 模组充电历史实体类
 */
public class BatteryChargeHistory implements Serializable {

    private static final long serialVersionUID = -8740534797229570319L;
    /**
     * 自增主键
     */
    private BigInteger id;
    /**
     * 电池模组ID
     */
    private String moduleId;
    /**
     * 剩余价值1
     */
    private Double remainingChargetime1;
    /**
     * 剩余价值2
     */
    private Integer remainingChargetime2;
    /**
     * 统计时间
     */
    private Timestamp statisticsTime;
    /**
     * 原始数据的indexhash值
     */
    private String indexhash;
    /**
     * 原始数据的mainhash值
     */
    private String mainhash;
    /**
     * 链上mainhash
     */
    private String chainMainhash;
    /**
     * 上链时间
     */
    private Timestamp chaintime;
    /**
     * 上链信息
     */
    private String chaininfo;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Double getRemainingChargetime1() {
        return remainingChargetime1;
    }

    public void setRemainingChargetime1(Double remainingChargetime1) {
        this.remainingChargetime1 = remainingChargetime1;
    }

    public Integer getRemainingChargetime2() {
        return remainingChargetime2;
    }

    public void setRemainingChargetime2(Integer remainingChargetime2) {
        this.remainingChargetime2 = remainingChargetime2;
    }

    public Timestamp getStatisticsTime() {
        return statisticsTime;
    }

    public void setStatisticsTime(Timestamp statisticsTime) {
        this.statisticsTime = statisticsTime;
    }

    public String getIndexhash() {
        return indexhash;
    }

    public void setIndexhash(String indexhash) {
        this.indexhash = indexhash;
    }

    public String getMainhash() {
        return mainhash;
    }

    public void setMainhash(String mainhash) {
        this.mainhash = mainhash;
    }

    public String getChainMainhash() {
        return chainMainhash;
    }

    public void setChainMainhash(String chainMainhash) {
        this.chainMainhash = chainMainhash;
    }

    public Timestamp getChaintime() {
        return chaintime;
    }

    public void setChaintime(Timestamp chaintime) {
        this.chaintime = chaintime;
    }

    public String getChaininfo() {
        return chaininfo;
    }

    public void setChaininfo(String chaininfo) {
        this.chaininfo = chaininfo;
    }
}
