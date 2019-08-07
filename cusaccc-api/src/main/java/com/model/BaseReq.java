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

        //发起机构
        private String br;


        private Long amt;


        private String ccy;

        //交易的发起人
        private String tlr;


}
