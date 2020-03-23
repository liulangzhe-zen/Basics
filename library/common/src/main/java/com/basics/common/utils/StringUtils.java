package com.basics.common.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @CreateDate: 2020-03-23 16:27
 * @Version: 1.0
 * @Description: String 工具类
 * @Author: xueshijie
 */
public class StringUtils {

    /**
     * String根据分割字符regex转换成List
     *
     * @param str
     * @param regex
     * @return
     */
    public static List<String> StringToList(String str, String regex) {
        List<String> strList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String[] strArr = str.split(regex);
            for (int i = 0; i < strArr.length; i++) {
                strList.add(strArr[i]);
            }
        }
        return strList;
    }

    /**
     * 将double类型的String去除末尾的.00
     *
     * @param str
     * @return
     */
    public static String StringTrailingZeros(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        BigDecimal bd = new BigDecimal(str);
        return bd.stripTrailingZeros().toPlainString();
    }

    /**
     * 集合数据去重
     *
     * @param list
     * @return
     */
    public static <T> List<T> removeDuplicate(List<T> list) {
        Set set = new HashSet();
        List<T> newList = new ArrayList<>();
        for (T element : list) {
            //set能添加进去就代表不是重复的元素
            if (set.add(element)) newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }


    /**
     * 截取 字符串 前面 字符
     *
     * @param
     * @return
     */
    public static String subFront(String str) {

        String userIdJiequ = str.substring(str.indexOf("--"));

        String split = ".png";
        StringTokenizer token = new StringTokenizer(userIdJiequ.substring(2), split);
        String name = token.nextToken();
        return name.substring(0, name.indexOf("x"));
    }

    /**
     * 截取 字符串 后面 字符
     *
     * @param
     * @return
     */
    public static String subAfter(String str) {

        String userIdJiequ = str.substring(str.indexOf("--"));

        String split = ".png";
        StringTokenizer token = new StringTokenizer(userIdJiequ.substring(2), split);
        String name = token.nextToken();
        return name.substring(name.indexOf("x") + 1);
    }
}
