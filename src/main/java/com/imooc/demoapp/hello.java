package com.imooc.demoapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaojing
 * @date 2019-09-24 16:09
 */


/*创建的一个类，一个Controller 需要添加注解@RestController标签，是由两个标签组成
 * 一个是@Controller 表示是一个Controller 能够用来接收前台发送过来的请求，能够用来做相应的数据处理、请求、响应、
 * 一个是@ResponseBody 是说将数据内容或对象 作为HTTP的相应正文返回。
 *
 * */
@RestController
public class hello {
    //    首先没有做配置情况下直接访问， http://localhost:8080/hello
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello springboot";
    }
}
