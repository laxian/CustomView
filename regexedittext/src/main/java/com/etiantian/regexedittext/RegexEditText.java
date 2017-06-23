package com.etiantian.regexedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zwx on 17-6-22
 */

public class RegexEditText extends android.support.v7.widget.AppCompatEditText {

    private final int mMode;
    private String mRegex;

    private static final int MODE_DENY = 0;
    private static final int MODE_ALLOW = 1;

    public RegexEditText(Context context) {
        this(context, null);
    }

    public RegexEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public RegexEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RegexEditText);

        mRegex = a.getString(R.styleable.RegexEditText_regex);
        mMode = a.getInt(R.styleable.RegexEditText_mode, 0);
        addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editable = getText().toString();

                String str;
                if (mMode == MODE_DENY) {
                    str = doFilter(editable);
                } else {
                    str = doFilterAllow(editable);
                }
                if (!editable.equals(str)) {
                    setText(str);
                    setSelection(str.length()); //光标置后
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}

        });
    }

    private String doFilterAllow(String rawText) {
        if (TextUtils.isEmpty(mRegex))
            return rawText;
        StringBuilder sb = new StringBuilder();

        Pattern p = Pattern.compile(mRegex);
        for (char c : rawText.toCharArray()) {
            if (p.matcher(c+"").matches()) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String doFilter(String rawText) {
        if (TextUtils.isEmpty(mRegex))
            return rawText;
        Pattern compile = Pattern.compile(mRegex);
        Matcher matcher = compile.matcher(rawText);
        return matcher.replaceAll("");
    }
}
