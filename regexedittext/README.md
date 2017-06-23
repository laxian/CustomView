# RegexEditText

使用正则表达式,限制输入内容

* 原理:
1. 分为两种过滤模式: allow模式和deny模式. allow模式下,正则表达式代表可以输入的字符.反之,deny模式下正则代表禁止输入的字符
2. 根据不同过滤模式, 结合正则表达式, 通过addTextChangedListener(),去掉不符合要求的字符. 

* 使用方法:


    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et1"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="@string/en_regex"
        android:hint="allow a-zA-Z"
        app:mode="allow"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et2"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="@string/en_di_regex"
        android:hint="deny a-zA-Z0-9"
        app:mode="deny"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et3"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="@string/cn_regex"
        android:hint="allow 汉字"
        app:mode="allow"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et4"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="@string/emoji_regex"
        android:hint="deny emoji"
        app:mode="deny"/>