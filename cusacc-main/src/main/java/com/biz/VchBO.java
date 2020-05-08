package com.biz;

import java.util.Date;

import java.util.List;
import lombok.Data;

@Data
public class VchBO {

    //传票模型
     private List<String> vch;

     private String vchNo;

     private String seq;

     private String totCnt;

    /**
     * 会计日 传票生效日
     */
    private Date acDate;

    /**
    * 交易日 交易日期 隔日传票
    */
     private Date trDate;

     private String ac;

     private String cdFlag;

     private Long amt;

     private String br;

     private String currentBal;

     private String tlr;

      /**
      * 顶级科目
      */
      private Integer  topItm;
      /**
      *二级科目
      */
      private Integer  middleItm;
      /**
      *
       * 三级序号
        */
      private Integer  lowItm;
}
