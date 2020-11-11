package com.leetcode;

import java.util.List;
import java.util.stream.Stream;

public class C1 {

    public static void main(String[] args) {
        while (true){

            String s = new String(new char[1000000]);

        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Stream.of(lists).forEach(
                listNode -> {
                    //取出每个list头 尾比较大小

                }
        );
        return null;
    }

    static void mergeTwoList(ListNode a , ListNode b){
        if(a==null || b ==null){
            return;
        }
        ListNode taila;
        ListNode heada;
        ListNode tailb;
        ListNode headb;
        int la=0;
        int lb =0;

        heada = a;
        headb = b;
        do {
            taila = a.next;
            ++la;
        }while ( taila != null&& taila.next !=null);
        do {
            tailb = b.next;
            ++lb;
        }while ( tailb != null&& tailb.next !=null);
        //比较2个list 头尾大小  a <= b
        if (taila.val <= headb.val){
            taila.next = b;
        }else if( tailb.val <= heada.val ){
            //  a>= b
            tailb.next = a;
        }else {
            //内嵌套的情况  小的插入大的
            if( la<=lb){
                ListNode n;
                n = a.next;
                while (a !=null){


                }

            }else {

            }

        }

    }

        class ListNode {
         int val;
        ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
