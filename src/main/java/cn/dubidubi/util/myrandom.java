package cn.dubidubi.util;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * @Auther: 16224
 * @Date: 2018/5/9 0009 20:35
 * @Description:
 */
public class myrandom {
    public static void main(String[] args){
        int a =0;
        int sum1=0,sum2=0,sum3=0;
        while(a < 10000){
            a++;
            int b =RandomUtils.nextInt(0,3);
            switch (b){
                case 0:sum1++;
                case 1:sum2++;
                case 2:sum3++;
            }
        }
        System.out.println(sum1*1.0/10000);
    }

}
