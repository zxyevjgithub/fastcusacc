package com.model;

import com.biz.VchBO;
import java.util.List;
import lombok.Data;

/**
 * @author devdws
 * @version Id: AccountMainMode.java, v 0.1  2020/4/26 15:54 devdws Exp $$
 */

@Data
public class AccountMainMode {


  private String trcode;

  /**
   当前根节点需要的所有因子
   */
  private List<String> factors;

  //因子权重得分
  private int score;

   /**
   * vch模型
   */
   private List<String> vchs;

  /**
   * 生成好的分录
   */
  private List<VchBO> vchBOS;
}
