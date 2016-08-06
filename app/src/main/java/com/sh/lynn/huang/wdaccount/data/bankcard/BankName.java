package com.sh.lynn.huang.wdaccount.data.bankcard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by hyz84 on 16/8/5.
 */
public class BankName {
    static HashMap<String, String> bankCode2Name = new HashMap<String, String>();

    static {
        bankCode2Name.put("0102", "工商银行");
        bankCode2Name.put("0103", "农业银行");
        bankCode2Name.put("0104", "中国银行");
        bankCode2Name.put("0105", "建设银行");
        bankCode2Name.put("0100", "邮储银行");
        bankCode2Name.put("0301", "交通银行");
        bankCode2Name.put("0302", "中信银行");
        bankCode2Name.put("0303", "光大银行");
        bankCode2Name.put("0304", "华夏银行");
        bankCode2Name.put("0305", "民生银行");
        bankCode2Name.put("0306", "广发银行");
        bankCode2Name.put("0307", "深发银行");
        bankCode2Name.put("0308", "招商银行");
        bankCode2Name.put("0309", "兴业银行");
        bankCode2Name.put("0310", "浦发银行");
        bankCode2Name.put("0403", "平安银行");
        bankCode2Name.put("0311", "北京银行");
        bankCode2Name.put("0401", "上海银行");
    }

    public static List<String> getBankName() {

        List<String> names = new ArrayList<>();

        Set<String> keys = bankCode2Name.keySet();
        //  Collections.
        for (String name : keys)
            names.add(bankCode2Name.get(name));

        return names;
    }
}
