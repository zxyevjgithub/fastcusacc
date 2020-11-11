package com.service;

import com.api.AccountCommonAPI;
import com.biz.AccountProcessHandler;
import com.github.luben.zstd.ZstdOutputStream;
import com.model.BaseReq;
import com.model.CommReq;
import com.model.CommRes;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author devdws
 * @version Id: AccountService.java, v 0.1  2019/7/23 18:28 devdws Exp $$
 */
@Service
@Slf4j
public class AccountService implements AccountCommonAPI {

    @Autowired
    AccountProcessHandler accountProcessHandler;

    @Override
    public CommRes doAccount(CommReq commReq) {
        return accountProcessHandler.genVchProcess(commReq);
    }

    public static void main(String[] args) {


        Dm dm = new Dm();
        dm.setSt(0);
        dm.setEd(2);

        Dm dm1 = new Dm();
        dm1.setSt(2);
        dm1.setEd(4);

        Dm dm2 = new Dm();
        dm2.setSt(1);
        dm2.setEd(3);

        cmBilibili(5, Stream.of(dm,dm1,dm2));
        long peekone = peekone(5, 2);
        System.out.println(peekone);

    }

    private static List<Dm> cmBilibili(int size, Stream<Dm> dm) {
        //填充数字 矩阵
            return null;
    }

    @Data
    static class Dm{
        int st;
        int ed;
    }

      static long peekone(int a,int b){
        int step =0;
        Integer[] aa = new Integer[a];
        Arrays.fill(aa, 1);
        long count=0;
        int stPos =b -1;
        for( int i = 1; i<  a ; ++i){
            step =  (int) Math.pow(b,i) % (   a-i +1) ;

            aa[stPos] = 0;
              count = Arrays.stream(aa).filter(d -> d.equals(1)).count();
                System.out.println("out = "+count);
                if(count==1){
                    break;
                }
                stPos= ( stPos  + step   ) % a  ;

        }
        return count;
    }
}
