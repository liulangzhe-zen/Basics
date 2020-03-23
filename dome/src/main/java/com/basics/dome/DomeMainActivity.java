package com.basics.dome;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.basics.ui.widget.PasswordEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xueshijie
 * @Description: 测试界面  放置Dome
 */
public class DomeMainActivity extends AppCompatActivity {

    private PasswordEditText PasswordEditText;

    private View view1, view2, view3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dome_main);

        initView();

        initOnClick();


    }

    private void initOnClick() {

        PasswordEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String str = PasswordEditText.getText().toString().trim();
                //输入框为0
                if (str.length() == 0) {
                    view1.setBackgroundColor(Color.rgb(205, 205, 205));
                    view2.setBackgroundColor(Color.rgb(205, 205, 205));
                    view3.setBackgroundColor(Color.rgb(205, 205, 205));
                } else if (str.length() < 8) {
                    view1.setBackgroundColor(Color.rgb(205, 205, 205));
                    view2.setBackgroundColor(Color.rgb(205, 205, 205));
                    view3.setBackgroundColor(Color.rgb(205, 205, 205));

                } else

                    //8 - 10 位 弱
                    if (str.length() >= 8 && str.length() <= 10) {
                        if (isFuhao(str)) {
                            //中
                            view1.setBackgroundColor(Color.rgb(255, 129, 128));
                            view2.setBackgroundColor(Color.rgb(255, 184, 77));
                            view3.setBackgroundColor(Color.rgb(205, 205, 205));
                        } else if (isContainAll(str)) {
                            //弱
                            view1.setBackgroundColor(Color.rgb(255, 129, 128));
                            view2.setBackgroundColor(Color.rgb(205, 205, 205));
                            view3.setBackgroundColor(Color.rgb(205, 205, 205));

                        }
                    } else
                        //11 - 13 位    中
                        if (str.length() >= 11 && str.length() <= 13) {
                            if (isFuhao(str)) {
                                //强
                                view1.setBackgroundColor(Color.rgb(255, 129, 128));
                                view2.setBackgroundColor(Color.rgb(255, 184, 77));
                                view3.setBackgroundColor(Color.rgb(113, 198, 14));
                            } else if (isContainAll(str)) {
                                //中
                                view1.setBackgroundColor(Color.rgb(255, 129, 128));
                                view2.setBackgroundColor(Color.rgb(255, 184, 77));
                                view3.setBackgroundColor(Color.rgb(205, 205, 205));
                            }

                        } else
                            //14 - 20 位    强
                            if (str.length() >= 14 && str.length() <= 20) {
                                if (isFuhao(str) && isContainAll(str)) {
                                    //强
                                    view1.setBackgroundColor(Color.rgb(255, 129, 128));
                                    view2.setBackgroundColor(Color.rgb(255, 184, 77));
                                    view3.setBackgroundColor(Color.rgb(113, 198, 14));
                                } else if (isContainAll(str)) {
                                    //强
                                    view1.setBackgroundColor(Color.rgb(255, 129, 128));
                                    view2.setBackgroundColor(Color.rgb(255, 184, 77));
                                    view3.setBackgroundColor(Color.rgb(113, 198, 14));
                                }

                            } else {

                            }

            }
        });


    }

    private void initView() {

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        PasswordEditText = findViewById(R.id.ed_pass_word);

    }


    /**
     * http://www.aijquery.cn/Html/jqueryjiqiao/200.html
     * 判断输入的 同时包含 大小写字母  数字 特殊符号
     *
     * @return boolean
     **/
    public boolean isFuhao(String msg) {
        String regEx = "^(?=.*[a-z])(?=.*[1-9])(?=.*[\\W])(?=.*[A-Z])$";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(msg);
        return m.find();
    }


    /**
     * 规则3：必须同时包含大小写字母及数字
     * 是否包含
     *
     * @param str
     * @return
     */
    public static boolean isContainAll(String str) {
        //定义一个boolean值，用来表示是否包含数字
        boolean isDigit = false;
        //定义一个boolean值，用来表示是否包含字母
        boolean isLowerCase = false;
        boolean isUpperCase = false;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLowerCase(str.charAt(i))) {
                //用char包装类中的判断字母的方法判断每一个字符
                isLowerCase = true;
            } else if (Character.isUpperCase(str.charAt(i))) {
                isUpperCase = true;
            }
        }
        String regex = "^[a-zA-Z0-9]+$";
        boolean isRight = isDigit && isLowerCase && isUpperCase && str.matches(regex);
        return isRight;
    }
}
