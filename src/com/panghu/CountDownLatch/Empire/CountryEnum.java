package com.panghu.CountDownLatch.Empire;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author: 胖虎
 * @date: 2019/8/10 23:45
 **/
public enum CountryEnum {
    /**
     *
     */
    ONE(1, "韩"),
    TWO(2, "魏"),
    THREE(3, "楚"),
    FOUR(4, "燕"),
    FIVE(5, "赵"),
    SIX(6, "齐");

    private int retCode;

    private String retMessage;

    private CountryEnum(int retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum get(int index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (countryEnum.retCode == index) {
                return countryEnum;
            }
        }
        return null;
    }

    public int getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }
}
