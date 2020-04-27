package com.method;

/**
 * @author devdws
 * @version Id: MethodFunction.java, v 0.1  2020/4/14 10:51 devdws Exp $$
 */

@FunctionalInterface
public interface  ProcessFunction<T> {

     <K extends T> K doProcess(K k, String processName);

}
