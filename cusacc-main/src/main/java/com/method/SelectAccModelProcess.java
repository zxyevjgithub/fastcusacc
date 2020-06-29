package com.method;

import com.biz.ApolloConfig;
import com.biz.TradeAccountFactorBO;
import com.model.AccountMainMode;
import com.model.CommReq;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 选择会计分录
 * @author devdws
 * @version Id: SelectAccModel.java, v 0.1  2020/4/14 11:20 devdws Exp $$
 */


@Component
public class SelectAccModelProcess implements ProcessFunction<AccountMainMode> {

   @Getter
   private final String name = "SelectAccModelProcess";

   @Autowired
   ApolloConfig apolloConfig;


   @Override
   public <K extends AccountMainMode> K doProcess(K k, String processName) {


      //根据交易填写的因子跟配置因子计算总得分
      int sc = 0;
//      for(String f : k.getFactors()){
//         sc += apolloConfig.getFactorWeMap().get(f);
//      }
      //根据总分寻找对于的分录
      List<String> vch = apolloConfig.getVchMap().get(sc);
      k.setScore(sc);
      k.setVchs(vch);
      return k;
   }
}
