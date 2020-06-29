package com.log;

import com.alibaba.fastjson.JSONObject;
import com.github.luben.zstd.ZstdOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
public class LogInterceptor implements MethodInterceptor, InitializingBean {



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("myloginterceprot {}",invocation);
        Object retVal= null;
        try {
            sendLogBefor(invocation);
            // This is an around advice: Invoke the next interceptor in the chain.
            // This will normally result in a target object being invoked.
            retVal = invocation.proceed();
        }
        catch (Throwable ex) {
            // target invocation exception
//            getSendLogAfterThrowing(retVal, ex);
            throw ex;
        }
        finally {
//            cleanupTransactionInfo(txInfo);
        }
        sendLogAfterReturning(invocation,retVal);
        return retVal;
    }

    private void sendLogBefor(MethodInvocation invocation) {
        Object[] arguments = invocation.getArguments();
        Class<?>[] parameterTypes = invocation.getMethod().getParameterTypes();
        List<Object> collect = Stream.of(arguments).collect(Collectors.toList());

        Stream.of(arguments).collect(Collectors.toList()).forEach( (a) -> System.out.println(a.toString()));
        log.info("入参{}", JSONObject.toJSONString(collect));
    }

    private void sendLogAfterReturning(MethodInvocation invocation ,Object retVal) {
        Method method =  invocation.getMethod();
        Parameter[] parameters = method.getParameters();
        Class<?> returnType = method.getReturnType();
        log.info("出参 {}",  retVal);
    }

    private void getSendLogAfterThrowing(MethodInvocation invocation ,Object retVal, Throwable ex) {

    }


    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
