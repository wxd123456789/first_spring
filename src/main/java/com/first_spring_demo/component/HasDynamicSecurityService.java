package com.first_spring_demo.component;

import cn.hutool.core.util.ArrayUtil;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HasDynamicSecurityService implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        assert beanFactory != null;
        String[] beansNames = beanFactory.getBeanNamesForType(DynamicSecurityService.class);
        return ArrayUtil.isNotEmpty(beansNames);
    }
}