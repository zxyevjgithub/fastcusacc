package com.model;

import java.util.Map;
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

        //请求系统
        private String reqSys;

        /**
         * 账户，账户属性 内部户，客户账户
         */
        private Map<String,AccountBO> accountList;


}
