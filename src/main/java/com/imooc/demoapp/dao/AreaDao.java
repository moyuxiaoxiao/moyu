package com.imooc.demoapp.dao;

import com.imooc.demoapp.entity.Area;

import java.util.List;

/**
 * @author xiaojing
 * @date 2019-09-27 14:12
 */
//dao层写的都是借口。实现
//    创建业务需要的增删改成方法。
//alt+enter 创建
public interface AreaDao {
    /**
     * 查询所有区域信息
     *
     * @return areaList
     */
    List<Area> queryArea();

    /**
     * 通过ID查询单条区域信息
     *
     * @return area
     */
    Area queryAreaById(int areaId);

    /**
     * 通过实体类添加单条区域信息
     *
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 通过实体类修改单条区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 通过实体类ID删除单条区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

}
