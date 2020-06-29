package com.log;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class LogAnnotationAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private Advice advice;
    private Pointcut pointcut;
    private LogInterceptor logInterceptor;

    public LogAnnotationAdvisor(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
        this.advice = buildAdvice();
        this.pointcut = buildPointcut();
    }

    public Pointcut getPointcut() {
        return this.pointcut;
    }

    public Advice getAdvice() {
        return this.advice;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (this.advice instanceof BeanFactoryAware) {
            ((BeanFactoryAware) this.advice).setBeanFactory(beanFactory);
        }
    }

    protected Advice buildAdvice() {
        return logInterceptor;
    }

    protected Pointcut buildPointcut() {
        Pointcut cpc = new AnnotationMatchingPointcut(Atlog.class, true);
        Pointcut mpc = AnnotationMatchingPointcut.forMethodAnnotation(Atlog.class);

        ComposablePointcut result = new ComposablePointcut(cpc).union(mpc);

        return result;
    }

}
