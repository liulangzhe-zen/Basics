package com.basics.common.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.amulyakhare.textdrawable.TextDrawable;

/**
 * @CreateDate: 2020-03-23 16:27
 * @Version: 1.0
 * @Description: 商品标签中  把图片放置到文字右边或者是左边
 * @Author: xueshijie
 */
public class TextDrawableUtils {


    private static TextDrawableUtils instance;

    public static TextDrawableUtils getInstance() {
        if (instance == null) {
            synchronized (TextDrawableUtils.class) {
                if (instance == null) {
                    instance = new TextDrawableUtils();
                }
            }
        }
        return instance;
    }

    /**
     * @param context 上下文
     * @param lableStr  标签信息
     * @param textColor  字体颜色
     * @param bgColor   标题背景颜色
     * @param radius   弧度
     * */

    public Drawable getDrawable(Context context, @Nullable String lableStr,
                                @Nullable @ColorRes int textColor,
                                @Nullable @ColorRes int bgColor,
                                @Nullable int radius){
        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;
        height = height / 38;
        width = width / 25;


        Drawable drawable = TextDrawable.builder()
                .beginConfig()
                .width(lableStr.length() * width)
                .height(height)
                .textColor(ContextCompat.getColor(context,textColor))
                .fontSize((int) (height * 0.7))
                .endConfig()
                .buildRoundRect(lableStr, ContextCompat.getColor(context,bgColor), radius);

        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        return drawable;
    }


    /**
     * @param textContext  内容文字
     * @param tv  textview 控件
     * @param drawable  多个或者单个drawble
     * */
    public void setTextStyle(@Nullable String textContext, TextView tv,
                             @Nullable Drawable... drawable) {
        SpannableStringBuilder spanText = new SpannableStringBuilder(textContext);
        // 替换0,1的字符
        int timeNumber =  0;
        if (drawable != null) {
            for (int i = 0; i < drawable.length; i++) {
                spanText.insert(i+timeNumber,"  ");
                spanText.setSpan(drawable[i]==null ? "" :new ImageSpan(drawable[i]),
                        i +timeNumber, i + 1 +timeNumber,
                        Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                timeNumber ++;
            }
        }
        tv.setText(spanText);
    }
}
