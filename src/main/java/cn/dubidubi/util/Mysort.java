package cn.dubidubi.util;

import org.apache.commons.lang3.RandomUtils;

/**
 * @Auther: 16224
 * @Date: 2018/5/15 0015 15:38
 * @Description:
 */
public class Mysort {
    //交换出正确的一个位置
    public static int swap(int[] array,int start,int end){
        //挖出最左边的空
        int x =array[start];
        while (start < end){
            //从后往前找
            while(end > start){
                if(array[end] < x){
                    array[start] =array[end];
                    break;
                }else {
                    end--;
                }
            }
            while (start < end){
                if(array[start] >x){
                    array[end] =array[start];
                    break;
                }else{
                    start++;
                }
            }
        }
        //正确的顺序 左边的都比x小,右边的都比x大
        array[start] =x;
        return end;
    }
    //递归 分而治之的调用交换
    public  static void sort(int[] array,int start,int end){
        //当start<end时，递归排序,否则结束
        //递归的分而治之，之后对产生的左右排序
        if(start < end){
            int position = swap(array,start,end);
            sort(array,start,position-1);
            sort(array,position+1,end);
        }
    }
    public static void main(String[] args){
       int[] array =new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] =RandomUtils.nextInt(0,100);
        }
        System.out.println("排序之前");
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            System.out.println("i1 = " + i1);
        }
        System.out.println("-------------------------------------");
        sort(array,0,9);
        for (int i = 0; i < array.length; i++) {
            int i1 = array[i];
            System.out.println("i1 = " + i1);
        }
    }
}
