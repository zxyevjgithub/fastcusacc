package com.biz;

import static java.lang.Thread.sleep;

import com.log.Atlog;
import com.method.GenVchpRrocess;
import com.method.SelectAccModelProcess;
import com.model.AccountMainMode;
import com.model.CommReq;
import com.model.CommRes;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * --------------------- 计算1：交易码+ 因子权重 -> 会计分录
 * 计算2：根据分录模型  -> 流水
 *
 * @author devdws
 * @version Id: AccountProcessHandler.java, v 0.1  2019/7/23 18:50 devdws Exp $$
 */

@Slf4j
@Component("daiweisong")
public class AccountProcessHandler {

  @Autowired
  ApolloConfig apolloConfig;

  @Autowired
  SelectAccModelProcess selectAccModelProcess;

  @Autowired
  GenVchpRrocess genVchpRrocess;

  @Atlog(adviceType = "ar",filds = "dddd")
  public CommRes genVchProcess(CommReq commReq) {

//    log.info("factorWeMap {}", apolloConfig);
//    //根据会计因子内存 根节点匹配分录
//   // List<Integer> integers = apolloConfig.getFactorBOMap().get(commReq.getTrcode());
//    TradeAccountFactorBO tradeAccountFactorBO = new TradeAccountFactorBO();
//    AccountMainMode accountMainMode = new AccountMainMode();
//    accountMainMode.setFactors(tradeAccountFactorBO.getFactors());
//    accountMainMode.setTrcode(tradeAccountFactorBO.getTrcode());
//
//    //获取因子得分
//    CompletableFuture<AccountMainMode> future = CompletableFuture
//        .completedFuture(accountMainMode)
//        .thenApplyAsync(accountMainMode1 -> selectAccModelProcess.doProcess(accountMainMode1, selectAccModelProcess.getName()))
//        .thenApplyAsync(accountMainMode1 -> genVchpRrocess.doProcess(accountMainMode1,genVchpRrocess.getName()));
//
//    try {
//         AccountMainMode accountMainMode2 = future.get();
//
//    } catch (InterruptedException | ExecutionException e) {
//      e.printStackTrace();
//    }
//    CommRes commRes = new CommRes();
//    commRes.setVchNo(accountMainMode.getVchBOS().get(0).getVchNo());
//    commRes.setAcDate(accountMainMode.getVchBOS().get(0).getAcDate());
    //根据传票的分类 异步跟新数据库
    CommRes commRes = new CommRes();
    commRes.setVchNo("20200505FFFFFTEST");
    return commRes ;
  }



}
