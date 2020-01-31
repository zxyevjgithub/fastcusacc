package com.biz;

import com.model.CommReq;
import com.model.CommRes;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * @author devdws
 * @version Id: AccountProcessHandler.java, v 0.1  2019/7/23 18:50 devdws Exp $$
 */
@Service
public class AccountProcessHandler  {

     //因子权重
     private HashMap<String,Integer> factorWeMap = new HashMap<>();

     //交易码 - 交易BO映射
     private HashMap<String,TradeAccountFactorBO> factorBOMap = new HashMap<>();

     //因子- 分录序号映射
     private HashMap<Integer, List<String>> vchMap = new HashMap<>();


     public void loadCache(){

     }

     public CommRes genVchProcess(CommReq commReq) {
          //根据会计因子内存 根节点匹配分录
          TradeAccountFactorBO tradeAccountFactorBO = getTradeScore(commReq);

          //根据总分寻找对于的分录
          List<String> vch = vchMap.get(tradeAccountFactorBO.getScore());

          //根据分录 循环填写传票
          ArrayList<VchBO> vchs = new ArrayList<>();
          for (String s : vch) {
               VchBO vchBO = doResolvVch(s);
               vchs.add(vchBO);
          }

          //根据传票的分类 异步跟新数据库
          return null;
     }

     //解析会计分录 生成传票信息
     private  VchBO doResolvVch (String s){

          return null;
     }


     private  TradeAccountFactorBO getTradeScore(CommReq commReq) {
          //获取交易需要的所有因子
          TradeAccountFactorBO tradeAccountFactorBO = factorBOMap.get(commReq.getTrcode());

          //根据交易填写的因子跟配置因子计算总得分
          int sc = 0;
          for(String f:tradeAccountFactorBO.getFactors()){
               sc += factorWeMap.get(f);
          }
          tradeAccountFactorBO.setScore(sc);
          return tradeAccountFactorBO;
     }


}
