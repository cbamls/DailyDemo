package com.qunar.algorithm;

/**
 * Created by ershu.liang on 2017/7/20.
 */
public class TestEnumMain {
    public static void main(String[] args) {
        AppealTypeEnum[] appealTypeEnums = AppealTypeEnum.values();
        System.out.println(appealTypeEnums[0].getValue());
    }
}
