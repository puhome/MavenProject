package com.brzt.springjavaconfig.condition;

import com.brzt.springjavaconfig.interf.IsExist;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Profiles;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

/**
 * Profile(org.springframework.context.annotation),应用于不同环境配置不同（开发环境、测试环境、生产环境）
 * 本示例参考Profile里的实现方式
 * @author puhome
 * @data 2020/7/31
 */
public class TeacherCondition implements Condition {

    /**
     *用来执行匹配，如果返回是是false spring忽略@Condition 标签标注的bean的实例化，如果是true 正常实例化
     * @param conditionContext
     * @param annotatedTypeMetadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        MultiValueMap<String, Object> attrs = annotatedTypeMetadata.getAllAnnotationAttributes(IsExist.class.getName());
        if (attrs != null) {
            for (Object value : attrs.get("value")) {
                System.out.println(value);
                System.out.println(conditionContext.getBeanFactory().getBeansOfType((Class<?>) value).size());
                if (conditionContext.getBeanFactory().getBeansOfType((Class<?>)value).size()>0) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
