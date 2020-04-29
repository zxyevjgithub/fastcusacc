import com.model.CommReq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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




      @Test
      public void  ddd(){
        System.out.println(333);
      }

      @Test
      public void dddf(){
          AccountService.doAccount( new CommReq());

      }

      class Node{
         private String time;
         private String dd;

      }

}
