package com.imooc.demoapp.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * @author xiaojing
 * @date 2019-09-24 22:42
 */
//用于数据库的连接的dao。

//@Configuration标明告诉spring容器需要来到这个类下面检索相关的bean
// 在spring初始化的时候就会检索到这个类去看到这个bean的方法去掉这个bean方法去caret一个这个bean，去供一会一个数据库的注入。
@Configuration
@MapperScan("com.imooc.demoapp.dao")
//去扫描一会将要创建的的一个package.配置mybatis的mapper的扫描路径
public class DataSourceConfiguration {
    //可以在这里直接赋值，但最好是统一到一起，那么久可以创建一个jdbc.properties
//    变量引入。$配置文件application.properties里引入变量名的值。
//    思考下是否放在其他文件下也能同样引入如jdbc.properties
    //@Value读取application.properties 文件的变量值
    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUsername;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    /**
     * # ssm springboot 都是封装了各类配置的spring框架的，不过springboot它封装的东西更多更便于配置。
     * # ssm 主要是在xml里面去做配置，springboot主要是在代码里面做配置，用的注解。
     * # 同样的都是得往spring容器里写值，spring里关键的是IOC控制反转（一个容器接收很多Bean） AOP
     */
    //这个地方Bean 名称dataSource是告诉容器我需要一个id 为dataSource的Bean。
    // ，有这个dataSource然后就需要生成这个dataSource得实例。
    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        //ComboPooledDataSource  c3p0连接池的类。创建出DataSources实例
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
/**       jdbcdriver  jdbcurl  jdbcUsername jdbcPassword
 *        需要定义的变量(快捷键 Alt+Enter提示创建属性)，全局变量。
 *       给DataSource设置属性。首先是驱动类，
 */
        dataSource.setDriverClass(jdbcDriver);//创建以后会提示一个异常PropertyVetoException，直接抛出就可以的。Alt+Enter提示
//      接着是连接url一般本地是localhost:3306
        dataSource.setJdbcUrl(jdbcUrl);
//      这个是连接的用户名 mysql本地root，oracl/scott
        dataSource.setUser(jdbcUsername);
//      这个是连接的密码 mysql本地123456
        dataSource.setPassword(jdbcPassword);
//        连接池关闭是否自动提交。false是不自动的去commit提交。 这个比较重要，才能让事务去做控制。
        dataSource.setAutoCommitOnClose(false);
        // 配置c3p0连接池的私有属性其他的连接池最大连线程数，连接池最小连线程数，连接超时时间之类的
        // 连接池最大线程数
        dataSource.setMaxPoolSize(30);
        // 连接池最小线程数
        dataSource.setMinPoolSize(10);
        // 连接超时时间
        dataSource.setCheckoutTimeout(10000);
        // 连接失败重试次数
        dataSource.setAcquireRetryAttempts(2);
        return dataSource;

    }

}
