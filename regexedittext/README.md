# RegexEditText

使用正则表达式,限制输入内容

* 自定义属性：

1. **mode**：allow/deny
2. **regex**: digit/letter/letter_digit/ch/emoji/**custom_regex**

    内置regex：
    + digit: [0-9]
    + letter_lower: [a-z]
    + letter_upper: [A-Z]
    + ch: [\u4E00-\u9FA5]
    + emoji: (?:[\uD83C\uDF00-\uD83D\uDDFF]|[\uD83E\uDD00-\uD83E\uDDFF]|[\uD83D\uDE00-\uD83D\uDE4F]|[\uD83D\uDE80-\uD83D\uDEFF]|[\u2600-\u26FF]\uFE0F?|[\u2700-\u27BF]\uFE0F?|\u24C2\uFE0F?|[\uD83C\uDDE6-\uD83C\uDDFF]{1,2}|[\uD83C\uDD70\uD83C\uDD71\uD83C\uDD7E\uD83C\uDD7F\uD83C\uDD8E\uD83C\uDD91-\uD83C\uDD9A]\uFE0F?|[\u0023\u002A\u0030-\u0039]\uFE0F?\u20E3|[\u2194-\u2199\u21A9-\u21AA]\uFE0F?|[\u2B05-\u2B07\u2B1B\u2B1C\u2B50\u2B55]\uFE0F?|[\u2934\u2935]\uFE0F?|[\u3030\u303D]\uFE0F?|[\u3297\u3299]\uFE0F?|[\uD83C\uDE01\uD83C\uDE02\uD83C\uDE1A\uD83C\uDE2F\uD83C\uDE32-\uD83C\uDE3A\uD83C\uDE50\uD83C\uDE51]\uFE0F?|[\u203C\u2049]\uFE0F?|[\u25AA\u25AB\u25B6\u25C0\u25FB-\u25FE]\uFE0F?|[\u00A9\u00AE]\uFE0F?|[\u2122\u2139]\uFE0F?|\uD83C\uDC04\uFE0F?|\uD83C\uDCCF\uFE0F?|[\u231A\u231B\u2328\u23CF\u23E9-\u23F3\u23F8-\u23FA]\uFE0F?)

    自定义regex
    + custom_regex: define in _layout_ or reference in _strings.xml_
    
    >Android 5.x 在strings.xml中写emoji会导致native层crash
    https://stackoverflow.com/questions/35792856/emoji-symbol-in-string-xml-crashes-app
    故定义在java代码中

3. **custom_regex**: string | reference

* 使用方法:

```
    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et1"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="letter"
        android:hint="allow a-zA-Z"
        app:mode="allow"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et2"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="digit|letter"
        android:hint="deny a-zA-Z0-9"
        app:mode="deny"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et3"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="ch"
        android:hint="allow 汉字"
        app:mode="allow"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et4"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="emoji"
        android:hint="deny emoji"
        app:mode="deny"/>

    <com.etiantian.regexedittext.RegexEditText
        android:id="@+id/et5"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        app:regex="custom_regex"
        app:custom_regex="[0-9a-f]"
        android:hint="0123456789abcdef"
        app:mode="allow"/>
```
