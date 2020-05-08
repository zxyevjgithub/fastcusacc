package com.method;

import com.biz.ApolloConfig;
import com.biz.VchBO;
import com.model.AccountMainMode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *  交易合法检查-针对不同交易做不同检查
 *  交易码/检查类/检查模型
 *  1-每个检查模块是单独的检查类型
 *  eg: 例如0021110 定期存款需要检查的步骤4步
 *      a 是否定期批量时间
 *      a 借方账户余额检查
 *      b 客户账户是否不动户，冻结，内部户是否
 *      c 入账账户是否合法
 *  将abcd每个看成一个Future,一旦一个Future返回失败，其他的全部cancle。
 *
 * @author devdws
 * @version Id: GenVchpRrocess.java, v 0.1  2020/4/14 11:20 devdws Exp $$
 */


@Component
public class PreCheckRrocess implements ProcessFunction<AccountMainMode> {

   @Getter
   private final String name = "PreCheckRrocess";

   @Autowired
   ApolloConfig apolloConfig;

  // @Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Throwable.class })
   @Override
   public <K extends AccountMainMode> K doProcess(K k, String processName) {

      return k;
   }


}
