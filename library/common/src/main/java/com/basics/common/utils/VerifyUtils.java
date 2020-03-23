package com.basics.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @CreateDate: 2020-03-23 16:29
 * @Version: 1.0
 * @Description: 正则表达式
 * @Author: xueshijie
 */
public class VerifyUtils {

    /**
     * 正则表达式:验证用户名(不包含中文和特殊字符)如果用户名使用手机号码或邮箱 则结合手机号验证和邮箱验证
     */
    public static final String REGEX_USERNAME = "[a-zA-Z]\\w{5,17}";


    /**
     * 正则表达式:验证密码同时包含 大小字母、数字、特殊符号
     */
    public static final String REGEX_PASSWORDS = "^(?=.*[a-z])(?=.*[1-9])(?=.*[\\W])(?=.*[A-Z])$";

    /**
     * 正则表达式:验证密码(不包含特殊字符)
     */
    public static final String REGEX_PASSWORD = "[a-zA-Z0-9]{6,16}";

    /**
     * 正则表达式:验证手机号
     */
    public static final String REGEX_MOBILE = "[1][3,4,5,7,8,9][0-9]{9}";

    /**
     * 正则表达式:验证邮箱
     */
    public static final String REGEX_EMAIL = "([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}";

    /**
     * 正则表达式:验证汉字
     */
    public static final String REGEX_CHINESE = "[\u4e00-\u9fa5]";
    /**
     * 偏旁部首
     */
    public static final String CHINESE_RADICAL_DIGISTS = "[犭凵巛冖氵廴纟讠礻亻钅宀亠忄辶弋饣刂阝冫卩疒艹疋豸冂匸扌丬屮衤勹彳彡]";

    /**
     * 正则表达式:验证URL
     */
    public static final String REGEX_URL = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**
     * 正则表达式:验证IP地址
     */
    public static final String REGEX_IP_ADDR = "(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})";

    /**
     * 正则表达式:验证输入类容是否是数字
     */
    public static final String CURRENT_TEXT_NUMBER = "[0-9]*";

    /**
     * 正则表达式：验证输入的类容是否有enmji
     */
    public static final String CURRENT_TEXT_EMOJI = "[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]";

    /**
     * 校验用户名
     *
     * @param username
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUserName(String username) {
        return Pattern.matches(REGEX_USERNAME, username);
    }

    /**
     * 校验密码
     *
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches(REGEX_URL, url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddress
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIPAddress(String ipAddress) {
        return Pattern.matches(REGEX_IP_ADDR, ipAddress);
    }

    /**
     * 校验字符串是否有中文
     *
     * @param text
     * @return 校验通过返回false，否则返回true
     */
    public static boolean isContainChinese(String text) {
        Pattern pattern = Pattern.compile(REGEX_CHINESE);
        Matcher matcher = pattern.matcher(text);
        return !matcher.find();
    }

    /**
     * 校验字符串是否是数字
     *
     * @param text
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isNumeric(String text) {
        return Pattern.matches(CURRENT_TEXT_NUMBER, text);
    }

    /**
     * 判断emjo表情
     * @param source
     * @return 校验通过返回false 失败返回true
     */
    public static boolean containsEmoji(String source) {
        Pattern emoji = Pattern.compile(CURRENT_TEXT_EMOJI,Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher emojiMatcher = emoji.matcher(source);
        return emojiMatcher.find();
    }


    /**
     * 字符串是否包含偏旁部首
     * */
    public static boolean isContainRadical(String str) {
        Pattern p = Pattern.compile(CHINESE_RADICAL_DIGISTS);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
