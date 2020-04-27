package com.biz;


import java.util.HashMap;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author devdws
 * @version Id: ApolloConfig.java, v 0.1  2020/4/26 15:04 devdws Exp $$
 */
@Configuration
@Data
public class ApolloConfig {

  /**
   *
  * 因子权重
   */
  @Value("${factorWeMap}")
  private HashMap<String,Integer> factorWeMap = new HashMap<>();

  /**
   *
   交易码 - 交易BO映射
   */
  @Value("${factorBOMap}")
  private HashMap<String,TradeAccountFactorBO> factorBOMap = new HashMap<>();

  /**
   *
   因子- 分录序号映射
   */
  @Value("${vchMap}")
  private HashMap<Integer, List<String>> vchMap = new HashMap<>();

}
