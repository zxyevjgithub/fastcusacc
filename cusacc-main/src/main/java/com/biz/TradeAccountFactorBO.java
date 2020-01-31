package com.biz;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class TradeAccountFactorBO {

    private String trcode;

    //当前根绝点需要的所有因子
    private List<String> factors;

    //因子权重得分
    private int score;


}
