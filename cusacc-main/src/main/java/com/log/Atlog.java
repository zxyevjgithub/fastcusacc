package com.log;

import org.apache.kafka.common.protocol.types.Field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Atlog {

     String adviceType() default "ar";

     String filds();
}
