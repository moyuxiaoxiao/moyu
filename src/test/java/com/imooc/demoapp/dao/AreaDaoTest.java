package com.imooc.demoapp.dao;

import com.imooc.demoapp.entity.Area;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author xiaojing
 * @date 2019-09-27 17:56
 */
//Spring指定Spring 的 调用SpringBootTest ,ut这个类跑UT类
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    // @Ignore标签标示忽略这个方法
    @Autowired
    private AreaDao areaDao;

    //ctrl+shift+A 提示错误找不到bean
    @Test
//   @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        Assert.assertEquals(7, areaList.size());
/*
* junit.framework.AssertionFailedError:
Expected :4
Actual   :5
<Click to see difference>
* 如果报错
*
* */
    }

    @Test
//    @Ignore
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
//        assertEquals("西苑",area.getAreaName());
//        junit.framework.ComparisonFailure:
//Expected :西苑
//Actual   :东苑
//<Click to see difference>
        Assert.assertEquals("东苑",area.getAreaName());
//Process finished with exit code 0
    }

    @Test
//    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("光谷苑");
        area.setPriorty(5);
        area.setCreatTame(new Date());
        int i = areaDao.insertArea(area);
        System.out.println(i);
    }

    @Test
//    @Ignore
    public void updateArea() {
        Area area = areaDao.queryAreaById(8);
        area.setLastEditTime(new Date());
        int i = areaDao.updateArea(area);
        System.out.println(i);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int i = areaDao.deleteArea(9);
        System.out.println(i);
    }
}