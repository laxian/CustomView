# RegexEditText

使用正则表达式,限制输入内容

* 原理:
1. 分为两种过滤模式: allow模式和deny模式. allow模式下,正则表达式代表可以输入的字符.反之,deny模式下正则代表禁止输入的字符
2. 根据不同过滤模式, 结合正则表达式, 通过addTextChangedListener(),去掉不符合要求的字符. 

* 使用方法:

```
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
```

```
<resources>
    <string name="app_name">regexedittext</string>
    <string name="action_settings">Settings</string>
    <string name="en_di_regex">[a-zAZ0-9]</string>
    <string name="en_regex">[a-zAZ]</string>
    <string name="cn_regex">[\u4E00-\u9FA5]</string>
    <string name="emoji_regex">(?:[\uD83C\uDF00-\uD83D\uDDFF]|[\uD83E\uDD00-\uD83E\uDDFF]|[\uD83D\uDE00-\uD83D\uDE4F]|[\uD83D\uDE80-\uD83D\uDEFF]|[\u2600-\u26FF]\uFE0F?|[\u2700-\u27BF]\uFE0F?|\u24C2\uFE0F?|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}|[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?|[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?|[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?|[\u2934\u2935]\uFE0F?|[\u3030\u303D]\uFE0F?|[\u3297\u3299]\uFE0F?|[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]\uFE0F?|[\u203C\u2049]\uFE0F?|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?|[\u00A9\u00AE]\uFE0F?|[\u2122\u2139]\uFE0F?|\uD83C\uDC04\uFE0F?|\uD83C\uDCCF\uFE0F?|[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]\uFE0F?)</string>
</resources>
```