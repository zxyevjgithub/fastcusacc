package com.biz;


import java.util.HashMap;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 每个因子在bitmap 长度512 中的位置是固定的，根据交易码做运算后可以得到唯一的一组会计分
 * 这个运算称为 匹配运算
 * eg:
 * 0021110 输入的bitmap 00010000 | 00000000 | 00000000 | 0001 1000
 * 即 cash = true, localflg = true
 * 因子类型是 bool String Integer 3种，String占3位
 * @author devdws
 * @version Id: ApolloConfig.java, v 0.1  2020/4/26 15:04 devdws Exp $$
 */


@Component
@Data
public class ApolloConfig {

  /**
   *
   * 因
   */
  // @Value("${factorWeMap}")
  // private HashMap<String,Integer> factorWeMap = new HashMap<>();

  /**
   *
   * 交易码 - 该交易码需要的因子offest, 从左向右  高位到低位，对应bitmap 512的位置
   */

  @Resource( name = "factored")
  private HashMap<String,List<Integer>> factored = new HashMap<>();

  /**
   *
   * bitmap 的位置和 因子name的映射
   */
  @Resource( name = "factorName")
  private HashMap<Integer,String> factorName = new HashMap<>();


  /**
   *
   * 因子- 分录序号映射
   * eg: 一年期定期部提
   *  0021100 001 - DCUS   客户定期账户
   *              - CCUS   客户活期
   *              - D40510 RED  一年期定期利息收入
   *              - C50312 RED  一年期定期应付利息
   *              - D40510 活期利息收入
   *              - C50312 活期应付利息
   *              - D50312
   *              - CCUS
   *
   *              - DCUS   手续费
   *              - C40210 手续费收入
   *
   */
  //@Value("${vchMap}")
  @Resource( name = "vchMap")
  private HashMap<Integer, List<String>> vchMap = new HashMap<>();

}
