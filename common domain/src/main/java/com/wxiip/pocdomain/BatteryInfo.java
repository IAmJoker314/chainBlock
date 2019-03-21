package com.wxiip.pocdomain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: 段燕娜
 * @Date: 2019年03月06日  14：06
 * @Description: 电池模组实体类
 */
public class BatteryInfo implements Serializable {

    private static final long serialVersionUID = 4819462877951808455L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 模组ID
     */
    private String  moduleId;

    private String moduleCellMinId;
    /**
     * 出厂时可充放电次数
     */
    private Integer originalChargeTimes;
    /**
     * 制造厂商
     */
    private String manufacturers;

    /**电池拥有者**/
    private String owner;

    /**
     * 信息生成时间
     */
    private Timestamp creatime;

    private int start;

    private int pageSize;

    private int currentPage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleCellMinId() {
        return moduleCellMinId;
    }

    public void setModuleCellMinId(String moduleCellMinId) {
        this.moduleCellMinId = moduleCellMinId;
    }

    public Integer getOriginalChargeTimes() {
        return originalChargeTimes;
    }

    public void setOriginalChargeTimes(Integer originalChargeTimes) {
        this.originalChargeTimes = originalChargeTimes;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public Timestamp getCreatime() {
        return creatime;
    }

    public void setCreatime(Timestamp creatime) {
        this.creatime = creatime;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
