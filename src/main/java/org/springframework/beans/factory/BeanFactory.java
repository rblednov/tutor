package org.springframework.beans.factory;

import java.util.Map;

public class BeanFactory {
    Map<String, Object> singletons;

    public Object getBean(String beanName) {
        return singletons.get(beanName);
    }
}
