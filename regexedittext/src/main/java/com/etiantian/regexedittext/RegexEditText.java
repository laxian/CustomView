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
    private final int mRegexFlag;
    private String mCustomRegex;
    private String mRegex;

    private static final int MODE_DENY = 0;
    private static final int MODE_ALLOW = 1;

    private static final int TYPE_DIGIT         = 1;
    private static final int TYPE_LETTER_LOWER  = 1 << 1;
    private static final int TYPE_LETTER_UPPER  = 1 << 2;
    private static final int TYPE_CH            = 1 << 3;
    private static final int TYPE_EMOJI         = 1 << 4;
    private static final int TYPE_CUSTOM_REGEX  = 1 << 5;

    public RegexEditText(Context context) {
        this(context, null);
    }

    public RegexEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public RegexEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RegexEditText);

        mMode = a.getInt(R.styleable.RegexEditText_mode, 0);
        mRegexFlag = a.getInt(R.styleable.RegexEditText_regex, 0);

        StringBuilder sb = new StringBuilder();
        if ((mRegexFlag & TYPE_CUSTOM_REGEX) != 0) {
            mCustomRegex = a.getString(R.styleable.RegexEditText_custom_regex);
            if (mCustomRegex != null) {
                sb.append(mCustomRegex).append("|");
            }
        }
        if ((mRegexFlag & TYPE_DIGIT) != 0) {
            sb.append(InternalRegex.DIGIT.regex).append("|");
        }
        if ((mRegexFlag & TYPE_LETTER_LOWER) != 0) {
            sb.append(InternalRegex.LETTER_LOWER.regex).append("|");
        }
        if ((mRegexFlag & TYPE_LETTER_UPPER) != 0) {
            sb.append(InternalRegex.LETTER_UPPER.regex).append("|");
        }
        if ((mRegexFlag & TYPE_CH) != 0) {
            sb.append(InternalRegex.CH.regex).append("|");
        }
        if ((mRegexFlag & TYPE_EMOJI) != 0) {
            sb.append(InternalRegex.EMOJI.regex).append("|");
        }
        if (sb.length() == 0) {
            mRegex = "";
        } else if (sb.charAt(sb.length()-1) == '|') {
            mRegex = sb.substring(0, sb.length() -1);
        } else {
            mRegex = sb.toString();
        }

        if (TextUtils.isEmpty(mRegex))
            return;
        addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String editable = getText().toString();

                String str;
                if (mMode == MODE_DENY) {
                    str = doFilterDeny(editable);
                } else {
                    str = doFilterAllow(editable);
                }
                if (!editable.equals(str)) {
                    setText(str);
                    setSelection(str.length()); //光标置后
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
    }

    private String doFilterAllow(String rawText) {
        if (TextUtils.isEmpty(mRegex))
            return rawText;
        StringBuilder sb = new StringBuilder();

        Pattern p = Pattern.compile(mRegex);
        for (char c : rawText.toCharArray()) {
            if (p.matcher(c + "").matches()) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String doFilterDeny(String rawText) {
        if (TextUtils.isEmpty(mRegex))
            return rawText;
        Pattern compile = Pattern.compile(mRegex);
        Matcher matcher = compile.matcher(rawText);
        return matcher.replaceAll("");
    }
}
