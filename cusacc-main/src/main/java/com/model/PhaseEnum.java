package com.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PhaseEnum {

    //余额检查
    CHECK(0,"GENSOCRE"),

    //根据会计银子获取得分
    GENSOCRE(1,"GENVCH"),

    //生成流水
    GENVCH(2,null),
    ;

    private Integer wet;

    private String next;

    public   static String getnext(PhaseEnum phaseEnum){
        PhaseEnum[] values = PhaseEnum.values();
        Stream<String> stringStream = Arrays.stream(values).map(phaseEnum1 -> {
            if (phaseEnum1.getWet().equals(phaseEnum.getWet())) {
                return phaseEnum1.getNext();
            } else {
                return null;
            }
        });
        List<String> collect = stringStream.collect(Collectors.toList());
        return collect.get(0);

    }

    public static PhaseEnum  getName(String a){
        PhaseEnum[] values = PhaseEnum.values();
        Stream<PhaseEnum> stringStream = Arrays.stream(values).map(phaseEnum1 -> {
           if(phaseEnum1.getNext().equals(a)){
               return phaseEnum1;
           }
           else {
               return null;
           }
        });
        List<PhaseEnum> collect = stringStream.collect(Collectors.toList());
        return collect.get(0);


    }

}
