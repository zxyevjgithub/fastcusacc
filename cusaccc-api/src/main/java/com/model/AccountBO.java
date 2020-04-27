package com.model;

import lombok.Data;

/**
 * @author devdws
 * @version Id: AccountBO.java, v 0.1  2020/4/26 14:16 devdws Exp $$
 */

@Data
public class AccountBO {

  /**
   * 币种
   */
  private String ccy;
  /**
   *
   * 账户属性 客户，内部
   */
    private String cLass;

  /**
   * 应计金额
   */
  private Long amt;


}
