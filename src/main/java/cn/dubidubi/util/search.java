package cn.dubidubi.util;

/**
 * @Auther: 16224
 * @Date: 2018/5/16 0016 21:06
 * @Description:
 */
public class search {
    //二分查找
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] evenArray = {1, 2, 3, 4, 5, 6};
        int l = 0;
        int r = array.length - 1;
        int search = 6;
        while (l <= r) {
            if (search < array[(l + r) / 2]) {
                r = (l + r) / 2 - 1;
            } else if (search > array[(l + r) / 2]) {
                l = (l + r) / 2 + 1;
            } else if (search == array[(l + r) / 2]) {
                System.out.println((l + r) / 2);
                break;
            }
        }
    }
}
