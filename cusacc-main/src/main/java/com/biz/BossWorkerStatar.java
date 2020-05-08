package com.biz;

import com.google.common.util.concurrent.*;
import com.model.AccountMainMode;
import com.model.PhaseEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 *
 * 启动boss 和 worker线程
 *
 */
@Component
@Data
@Slf4j
public class BossWorkerStatar {

      final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,50,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(500)) ;
      final ListeningExecutorService checkworker = MoreExecutors.listeningDecorator(threadPoolExecutor);
      final ListeningExecutorService vchworker = MoreExecutors.listeningDecorator(threadPoolExecutor);
      final ListeningExecutorService genworker = MoreExecutors.listeningDecorator(threadPoolExecutor);

      final BlockingQueue<AccountProcessHandler2.AccountEvent> task = new ArrayBlockingQueue(2000);


      @PostConstruct
      public void bossThread(){
          Thread thread = new Thread( () -> {
              while (task.peek()!=null){

                  AccountProcessHandler2.AccountEvent poll = task.poll();

                  if(poll!=null ){
                      switch (poll.getAccountMainMode().getPhaseEnum()){
                          case CHECK:
                              ListenableFuture<AccountMainMode> submit1 = checkworker.submit(poll);

                              Futures.addCallback(submit1, new FutureCallback<AccountMainMode>() {
                                  @Override
                                  public void onSuccess(AccountMainMode result) {
                                      //进入下个阶段
                                      result.setPhaseEnum(PhaseEnum.valueOf( result.getPhaseEnum().getNext()) );
                                      poll.setAccountMainMode(result);
                                      task.add(poll);
                                  }

                                  @Override
                                  public void onFailure(Throwable t) {

                                  }
                              });
                          case GENVCH:
                              ListenableFuture<AccountMainMode> submit2 = vchworker.submit(poll);
                              submit2.addListener(() -> {

                              },threadPoolExecutor);

                          case GENSOCRE:
                              ListenableFuture<AccountMainMode> submit3 = genworker.submit(poll);
                              submit3.addListener(() -> {

                              },threadPoolExecutor);
                          default:
                              break;
                      }
                  }
              }
          });

          thread.setDaemon(true);

          thread.start();
            log.info("poll启动");
      }



}
