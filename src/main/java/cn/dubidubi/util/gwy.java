package cn.dubidubi.util;

import org.apache.commons.lang3.RandomUtils;

/**
 * @Auther: 16224
 * @Date: 2018/5/19 0019 17:38
 * @Description:
 */
public class gwy {

    public static void main(String[] args) {

        int flag = 0;
        while (flag < 100) {
            int ParameterA = RandomUtils.nextInt(1000, 100000);
            int ParameterB = RandomUtils.nextInt(1000, 100000);
            float ParameterC = RandomUtils.nextFloat(1.0F, 100.0F);
            int ParameterD = 0;
            if (flag % 3 == 0) {
                ParameterD = RandomUtils.nextInt(100, 1000);
            }
            System.out.print(ParameterA + "*" + ParameterB + "/" + ParameterC);
            if (ParameterD != 0) {
                System.out.print("*" + ParameterD);
                System.out.println("");
            }
            flag++;
        }
    }
}
