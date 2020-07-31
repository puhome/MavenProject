package com.brzt.springjavaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 *@ComponentScan 自动的完成spring组件的扫描（默认情况下，@ComponentScan扫描被标注的类的对应的包及其子包中的所有类）
 *一般主配置对象，放在代码的跟目录下面
 * @author puhome
 * @data 2020/7/31
 */

@Import({RedisConfig.class,DataSourceConfig.class})
//@ImportResource(locations = {"classpath:com/brzt/springjavaconfig/ApplicationContext.xml"})  找不到文件
//@PropertySource({"classpath:com/brzt/springjavaconfig/db.properties"}) 找不到文件
@Configuration
@ComponentScan
public class ConfigNew {

}
