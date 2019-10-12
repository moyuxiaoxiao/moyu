package com.imooc.demoapp.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author xiaojing
 * @date 2019-09-26 11:38
 */
//SessionFactory的配置去供我们做事务的提交，只要做相关配置打上相关标签，
//    告诉spring去扫描这个类，同时我们在里面先set上mybatis的文件，
// 在这里是将DataSource 跟mybatis可以绑定到一块，并且创建出支持事务的sessionfactory来。
@Configuration
public class SessionFactoryConfiguration {
    //
    @Value("${mybatis_config_file}")
    private String mybatisConfigFilePath;
    @Value("${mapper_path}")
    private String mapperpath;

    /* 因为出现重复需要指定bean别名 出现提示红色 后面改成warming*/
    @Autowired//添加的是实体属性
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Value("${entity_package}")
    private String entityPackage;

    //在spring容器加载的时候,需要加载出一个bean来，这个bean叫做sqlSessionFactory。
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean creatSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
// 设置 mybatisConfiguration的扫描路径，就是扫描mybatis-config的配置文件。
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
//mybatis 的配置主要是有两个部分组成，第一个是就是扫描mybatis-config的配置文件  另一个mapper文件
//        mapper主要是用来实现dao层相关的操作。
// mybatis它作为一个orm框架的作用就是将咱们的前台发送过来的对数据库的请求转换成对数据库能识别的语言sql语句。
//        就是掉用jdbc转换成数据库能识别的sql语句，然后去操作数据库。
// 操作数据库后就能返回结果，又能将返回结果映射成程序。面向对象编程程序能识别的数据，将它赋值到相关的实体类里面去。去返回给我们做调用。
//        这是 mapper比较重要的作用，他就是用来定义一些格式化的规范的。
//        接下来指定mapper 的路径，
// 不论spring或者mybatis也好，他的数据文件流的处理都离不开resolver，这里用到的是PathMatchingResourcePatternResolver
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//       创建出这么PathMatchingResourcePatternResolver个类然后还要指定出package它的扫描路径及mapper文件的扫描路径。
        //    CLASSPATH_ALL_URL_PREFIX    告诉spring容器要去classepath及resource下面去找寻mapper文件。
//       就是CLASSPATH_ALL_URL_PREFIX = "classpath*:就是要去项目的根路径去寻找相关的配置文件。mapperpath就能定位先关的mapper
        String packageSearchPth = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperpath;
//        resolver.getResources() 去读取mapper的路径，然后加载到sqlSessionFactoryBean中。
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPth));
//      还需要设置上DataSource。
        sqlSessionFactoryBean.setDataSource(dataSource);
//       设置 光有DataSource 、 mybatis-config文件、mapper 也还是不完整的，还有要映射实体类。需要传入实体类的扫描路径。
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
//        那么有了这四个属性，我们就可以直接return这个sqlSessionFactoryBean就可以了。
        return sqlSessionFactoryBean;
    }

}
