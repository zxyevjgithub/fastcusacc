package com.biz;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Data
public class EplipsComputer {

    //椭圆函数
    private double x;

    //椭圆函数
    private double y;

    //左边 还是右边 x>0是右边
    private int postiveFlag;

    //随机质量
    private  final double  density =   Math.random();

    //Y的除数
    private static final int Y_MOD = 2;
    //X的除数
    private static final int X_MOD = 2;

    //构建椭圆节点
    public EplipsComputer(double x,  int postiveFlag) {
        this.x = x;
        this.postiveFlag = postiveFlag;
        this.y= computeY(x,postiveFlag);

    }

    //构建质心
    public EplipsComputer(double x,double y){
        this.x=x;
        this.y=y;
    }

    //根据X获取Y y^2/64 + x^2/16 = 1
    private   double computeY(double x,int postiveFlag){
        double y = Math.sqrt(  (1 - Math.pow(x, 2) / X_MOD) * Y_MOD);
        if(postiveFlag>0){
            return y;
        }
        //java开不出来负数
        return -1*y;
    }

    /**
     * 计算质心
     *  杠杆平衡原理  X质量 * k = (距离-K)* Y质量
     * @param list
     * @return
     */
    public static EplipsComputer computeMcenter(final List<EplipsComputer> list){

         if(CollectionUtils.isEmpty(list)){
             return null;
         }

         EplipsComputer preE=null ;
         for(EplipsComputer e:list){
              //计算2个节点中心
             if(preE==null){
                 preE =e;
             }else {
                 //Dx
                  double dx = Math.abs( preE.getX()-e.getX());
                  double dy = Math.abs( preE.getY()-e.getY());
                  double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
                  //按照重量分配距离  k * preE.density = e.density * (distance -k);
                 //    k * preE.density + k* e.d = e.density * distance k是长度
                  double k = e.density* distance / ( preE.density + e.density);
                  //求出比例
                  double newX = ( k/distance) * dx;
                  double newY = ( k/distance) * dy;
                    //产生一个新的节点

                 preE= new EplipsComputer(newX,newY);
             }
         }


        return preE;
    }

    public static void main(String[] args) {

        List<EplipsComputer> l = new ArrayList<>();
        for( int i=0;i<2;i++){
            Random random = new Random();
            double v = random.nextDouble();
            //int i1 = random.nextInt(3);
           // double x =v+ Double.valueOf(i1);

            Double pow = Math.pow(-1, i);

        }

        EplipsComputer e1 = new EplipsComputer(1, 1);
        EplipsComputer e2 = new EplipsComputer(1, -1);

        log.info(" ddd{} , {}",e1,e2);
        l.add(e1);
        l.add(e2);

        EplipsComputer eplipsComputer =  computeMcenter(l);
        log.info( "dd {} ",eplipsComputer);


    }






}
