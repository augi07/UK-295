package ch.csbe.productstore    .security;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.stereotype.Component;

@Component
public class PostProcessorBean implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AuthorizationFilter authorizationFilter) {
            authorizationFilter.setFilterErrorDispatch(false);
        }
        return bean;
    }
}
