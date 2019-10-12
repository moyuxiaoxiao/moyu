package com.imooc.demoapp.entity;

import java.util.Date;

/**
 * @author xiaojing
 * @date 2019-09-24 17:59
 */
public class Area {
    //    c创建Getter Setter Constructer 右键Generate-->Getter Setter Constructer 全部选中
//   主键
    private Integer areaId;
    //   区域名称
    private String areaName;
    //   权重，权重越大越往前排显示
    private Integer priorty;
    //    创建时间
    private Date creatTame;
    //    更新时间
    private Date lastEditTime;
    public Area() {
    }
    public Area(Integer areaId, String areaName, Integer priorty, Date creatTame, Date lastEditTime) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.priorty = priorty;
        this.creatTame = creatTame;
        this.lastEditTime = lastEditTime;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setPriorty(Integer priorty) {
        this.priorty = priorty;
    }

    public void setCreatTame(Date creatTame) {
        this.creatTame = creatTame;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public Integer getPriorty() {
        return priorty;
    }

    public Date getCreatTame() {
        return creatTame;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }
}
