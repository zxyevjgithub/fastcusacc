package com.log;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class LogProcess  extends AbstractAdvisingBeanPostProcessor implements BeanFactoryAware {
    @Resource(name="logInterceptor")
    private LogInterceptor logInterceptor;


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        setBeforeExistingAdvisors(true);
        LogAnnotationAdvisor advisor = new LogAnnotationAdvisor(logInterceptor);
        advisor.setBeanFactory(beanFactory);
        this.advisor = advisor;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    protected boolean isEligible(Class<?> targetClass) {
        Method[] methods = targetClass.getMethods();
             ArrayList<Annotation> objects = Lists.newArrayList();
             Stream.of(methods).forEach(
                     (a) -> {
                       Stream.of(a.getAnnotations()).forEach(
                               (b)->  { if(b.annotationType() == Atlog.class ) objects.add(b) ;}
                       );

                     ;
                     });

        if(!CollectionUtils.isEmpty(objects)){
            return true;
        }
        return super.isEligible(targetClass);
    }

    //
//    private List<String> cacheName;
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//
//             log.info("ddddddddddddd");
//
//             Method[] methods = bean.getClass().getMethods();
//             ArrayList<Annotation> objects = Lists.newArrayList();
//             Stream.of(methods).forEach(
//                     (a) -> {
//                       Stream.of(a.getAnnotations()).forEach(
//                               (b)->  {objects.add(b) ;}
//                       );
//
//                     ;
//                     });
//             log.info("sss{}",objects);
//             if(CollectionUtils.isEmpty(objects)){
//                 cacheName.add(beanName);
//             }
//
//         return bean;
//    }
}
