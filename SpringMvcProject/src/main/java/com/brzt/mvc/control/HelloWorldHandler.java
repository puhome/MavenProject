package com.brzt.mvc.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求控制器
 */
@Controller
public class HelloWorldHandler {

    /**
     *处理客户端请求：url/hello
     * 缺少mvc依赖，导致测试时一直404，启动tomcat时 可以观察 Server旁边的tomcat log
     * @return
     */
    @RequestMapping(value="/hello")
    public String handlerHello(){
        System.out.println("mvc success");
        return "HelloSuccess";//通过视图解析器解析到具体的视图，在转发去往该视图
    }

    HelloWorldHandler(){
        System.out.println("执行了吗");
    }
}
