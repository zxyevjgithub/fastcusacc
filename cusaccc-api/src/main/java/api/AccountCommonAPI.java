package api;

import model.CommReq;
import model.CommRes;
/**
 * @author devdws
 * @version Id: AccountCommonReq.java, v 0.1  2019/7/23 16:55 devdws Exp $$
 */
public interface AccountCommonAPI {


    CommRes doAccount(CommReq commReq);
}
