package com.basics.common.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.List;

/**
 * @CreateDate: 2020-03-23 16:30
 * @Version: 1.0
 * @Description: 判断本地是否存在微信跟支付宝
 * @Author: xueshijie
 */
public class WxUtils {

    /**
     * 判断手机是否安装微信
     * true 安装  false 没安装
     *
     * @param context 上下文
     * @return
     */
/*
    public static boolean isWxAppInstalledAndSupported(Context context) {
        IWXAPI wxApi = WXAPIFactory.createWXAPI(context, AppConfig.WX_APP_KEY);

        boolean bIsWXAppInstalledAndSupported = wxApi .isWXAppInstalled() && wxApi.isWXAppSupportAPI();
        if (!bIsWXAppInstalledAndSupported) {
            final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
            List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
            if (pinfo != null) {
                for (int i = 0; i < pinfo.size(); i++) {
                    String pn = pinfo.get(i).packageName;
                    if (pn.equals("com.tencent.mm")) {
                        return true;
                    }
                }
            }
            return false;
        }

        return true;
    }
*/


    /**
     * 检测是否安装支付宝
     * @param context
     * @return
     */
/*    public static boolean isAliPayInstalled(Context context) {
        Uri uri = Uri.parse("alipays://platformapi/startApp");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        ComponentName componentName = intent.resolveActivity(context.getPackageManager());
        return componentName != null;
    }*/
}
