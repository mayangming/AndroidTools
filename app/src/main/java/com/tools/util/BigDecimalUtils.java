package com.tools.util;

import java.math.BigDecimal;

/**
 * 高精度数值计算工具类
 */
public class BigDecimalUtils {

    /**
     * 将long类型转为BigDecimal
     */
    public static BigDecimal long2BigDecimal(long value){
        BigDecimal bigDecimal = new BigDecimal(value);
        return bigDecimal;
    }

    /**
     * 将分转为元
     */
    public static BigDecimal penny2Dollar(long value){
        BigDecimal pennyBigDecimal = BigDecimal.valueOf(value);
        BigDecimal diffBigDecimal = BigDecimal.valueOf(100);
        BigDecimal result = pennyBigDecimal.divide(diffBigDecimal,2,BigDecimal.ROUND_DOWN);
        return result;
    }

    /**
     * 将元转为分
     */
    public static BigDecimal dollar2PennyFor(double value){
        BigDecimal dollarBigDecimal = BigDecimal.valueOf(value);
        BigDecimal diffBigDecimal = BigDecimal.valueOf(100);
        BigDecimal result = dollarBigDecimal.multiply(diffBigDecimal);
        return result;
    }
    /**
     * 将元转为分
     */
    public static BigDecimal dollar2Penny(String value){
        BigDecimal dollarBigDecimal = new BigDecimal(value);
        BigDecimal diffBigDecimal = BigDecimal.valueOf(100);
        BigDecimal result = dollarBigDecimal.multiply(diffBigDecimal);
        return result;
    }
}