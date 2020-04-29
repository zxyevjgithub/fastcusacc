package com.biz;

import com.method.GenVchpRrocess;
import com.method.SelectAccModelProcess;
import com.model.AccountMainMode;
import com.model.CommReq;
import com.model.CommRes;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * 计算1：交易码+ 因子权重 -> 会计分录
 * 计算2：根据分录模型  -> 流水
 *
 * @author devdws
 * @version Id: AccountProcessHandler2.java, v 0.1  2019/7/23 18:50 devdws Exp $$
 */

@Slf4j
@Component
public class AccountProcessHandler2 {

  @Autowired
  ApolloConfig apolloConfig;

  @Autowired
  SelectAccModelProcess selectAccModelProcess;

  @Autowired
  GenVchpRrocess genVchpRrocess;

  @Transactional
  public CommRes genVchProcess(CommReq commReq) {

    return null;
  }



}
