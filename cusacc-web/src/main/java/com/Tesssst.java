package com;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author devdws
 * @version Id: Tesssst.java, v 0.1  2019/8/1 12:57 devdws Exp $$
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
@Slf4j
public class Tesssst {

    @Test
    public void  ddd(){
        System.out.println(333);

    }


}
