package com.service;

import com.api.AccountCommonAPI;
import com.biz.AccountProcessHandler;
import com.model.BaseReq;
import com.model.CommReq;
import com.model.CommRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author devdws
 * @version Id: AccountService.java, v 0.1  2019/7/23 18:28 devdws Exp $$
 */
@Service
public class AccountService implements AccountCommonAPI {

    @Autowired
    AccountProcessHandler accountProcessHandler;

    public CommRes doAccount(CommReq commReq) {
        return accountProcessHandler.genVchProcess(commReq);
    }


    public static void main(String[] args) {

        System.out.println("ff");

    }
}
