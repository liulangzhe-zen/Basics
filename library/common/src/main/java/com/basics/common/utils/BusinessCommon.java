package com.basics.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;

import java.util.List;

/**
 * @CreateDate: 2020-03-23 16:34
 * @Version: 1.0
 * @Description: 金额的处理
 * @Author: xueshijie
 */
public interface BusinessCommon {

    /**
     * 价格统一处理,封装
     *
     * @param price 价格
     * @return 货币单位字体缩小80%的价格字符串
     */
    static SpannableStringBuilder currencyTransformPrice(double price) {
        return currencyTransformPrice(String.valueOf(price));
    }

    /**
     * 价格统一处理,封装
     *
     * @param price 价格
     * @return 货币单位字体缩小80%的价格字符串
     */
    static SpannableStringBuilder currencyTransformPrice(String price) {
        price = TextUtils.isEmpty(price) ? "0.00" : price;
        SpannableStringBuilder priceString = new SpannableStringBuilder("￥" + price);
        priceString.setSpan(new RelativeSizeSpan(0.8f), 0, 1
                , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return priceString;
    }

    /**
     * 弹出拨打电话界面
     *
     * @param phoneNum 号码
     */
    static void dial2Phone(Context context, String phoneNum) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        if (isIntentAvailable(context.getPackageManager(), dialIntent)) {
            context.startActivity(dialIntent);
        } else {
            // TODO:Cauchy 2019-12-18 未找到电话应用处理
        }
    }

    /**
     * 判断隐式intent存在
     */
    static boolean isIntentAvailable(PackageManager packageManager, Intent intent) {
        List<ResolveInfo> activityList = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return ListUtils.isNotEmpty(activityList);
    }
}
