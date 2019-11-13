package com.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * @author devdws
 * @version Id: BaseReq.java, v 0.1  2019/7/23 18:00 devdws Exp $$
 */
@Data
public class BaseReq implements Serializable {


        //业务系统发生业务时间
        private Date tradeTime;

        //交易码- root节点
        private String trcode;

        //归属机构
        private String br;

        //金额
        private Long amt;

        //币种
        private String ccy;

        //请求系统
        private String reqSys;


}
