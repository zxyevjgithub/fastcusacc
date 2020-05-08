package com.biz;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.method.GenVchpRrocess;
import com.method.SelectAccModelProcess;
import com.model.AccountMainMode;
import com.model.CommReq;
import com.model.CommRes;

import java.util.List;
import java.util.concurrent.*;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * Ractor 模型
 * 计算1：交易码+ 因子权重 -> 会计分录 EVENT GETFENLU
 * 计算2：根据分录模型  -> 流水  ENVENT GENVCH
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

  @Autowired
  BossWorkerStatar bossWorkerStatar;



  public CommRes genVchProcess(CommReq commReq) {
    //

    TradeAccountFactorBO tradeAccountFactorBO = apolloConfig.getFactorBOMap().get(commReq.getTrcode());
    AccountMainMode accountMainMode = new AccountMainMode();
    accountMainMode.setFactors(tradeAccountFactorBO.getFactors());
    accountMainMode.setTrcode(tradeAccountFactorBO.getTrcode());


    AccountEvent accountEvent = new AccountEvent(accountMainMode, apolloConfig, selectAccModelProcess, genVchpRrocess);
    bossWorkerStatar.task.add(accountEvent);
//      ListenableFuture<List<AccountMainMode>> listListenableFuture = Futures.successfulAsList(accountEvent);
    CommRes commRes = new CommRes();
    commRes.setVchNo(accountMainMode.getVchBOS().get(0).getVchNo());
    commRes.setAcDate(accountMainMode.getVchBOS().get(0).getAcDate());
    return commRes;

  }

  @Data
  class AccountEvent implements Callable<AccountMainMode> {

    private AccountMainMode accountMainMode;

    private ApolloConfig apolloConfig;

    private SelectAccModelProcess selectAccModelProcess;

    private GenVchpRrocess genVchpRrocess;



    public AccountEvent(AccountMainMode accountMainMode, ApolloConfig apolloConfig, SelectAccModelProcess selectAccModelProcess, GenVchpRrocess genVchpRrocess) {
      this.accountMainMode = accountMainMode;
      this.apolloConfig = apolloConfig;
      this.selectAccModelProcess = selectAccModelProcess;
      this.genVchpRrocess = genVchpRrocess;
    }

    @Override
    public AccountMainMode call() throws Exception {

      switch (accountMainMode.getPhaseEnum()) {
        case CHECK:


        case GENVCH:


        case GENSOCRE:
        default:
          break;
      }

      return accountMainMode;
    }

  }


}
