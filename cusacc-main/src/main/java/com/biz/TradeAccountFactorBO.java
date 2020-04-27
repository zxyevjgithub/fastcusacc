package com.biz;

import lombok.Data;

import java.util.List;

@Data
public class TradeAccountFactorBO {

    private String trcode;

    /**
    当前根节点需要的所有因子
     */
    private List<String> factors;


}
