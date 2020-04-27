package com.method;

import com.biz.ApolloConfig;
import com.biz.VchBO;
import com.model.AccountMainMode;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 根据分录生成流水
 * @author devdws
 * @version Id: GenVchpRrocess.java, v 0.1  2020/4/14 11:20 devdws Exp $$
 */


@Component
public class GenVchpRrocess implements ProcessFunction<AccountMainMode> {

   @Getter
   private final String name = "GenVchpRrocess";

   @Autowired
   ApolloConfig apolloConfig;


   @Override
   public <K extends AccountMainMode> K doProcess(K k, String processName) {
      List<VchBO> vchs = new ArrayList<>();
      for (String s : k.getVchs()) {
         VchBO vchBO = doResolvVch(s,k);
         vchs.add(vchBO);
      }

      k.setVchBOS(vchs);
      return k;
   }

   //解析会计分录 生成传票信息
   private VchBO doResolvVch(String s, AccountMainMode accountMainMode) {

      return null;
   }
}
