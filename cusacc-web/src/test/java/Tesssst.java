import com.biz.AccountProcessHandler;
import com.biz.ApolloConfig;
import com.model.CommReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author devdws
 * @version Id: Tesssst.java, v 0.1  2019/8/1 12:57 devdws Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:a.xml"})
@Slf4j
public class  Tesssst {

     @Autowired
     com.service.AccountService AccountService;

    @Autowired
    ApolloConfig apolloConfig;

    @Autowired
    AccountProcessHandler daiweisong;


      @Test
      public void  ddd(){
          System.out.println(System.getProperties());

          Node node = new Node();

      }

      @Test
      public void dddf(){
         // AccountService.doAccount( new CommReq());sout
          CommReq commReq = new CommReq();
          commReq.setIsCash(true);
          commReq.setBr("310110");
          daiweisong.genVchProcess(commReq);
      }

      class Node{
         private String time;
         private String dd;

      }

}
