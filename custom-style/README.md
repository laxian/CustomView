### custom-style


Android自定义View,构造函数有4个:

    public View(Context context) 

    public View(Context context, @Nullable AttributeSet attrs) 

    public View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) 

    public View(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes)
     
其中,在代码中创建,走第一个构造函数. 在xml中定义, 走第二个. 第三个,第四个需要我们显示调用.

4个参数的意思分别是：

　　　　_context_：

　　　　_attrs_：从xml读取的AttributeSe

　　　　_defStyleAttr_：这个是当前Theme中的一个attribute，是指向style的一个引用，当在layout xml中和style中都没有

　　　　为View指定属性时，会从Theme中这个attribute指向的Style中查找相应的属性值，这就是defStyle的意思，如果没有
　　　　
　　　　指定属性值，就用这个值，所以是默认值，但这个attribute要在Theme中指定，且是指向一个Style的引用，如果这个参数

　　　　传入0表示不向Theme中搜索默认值

　　　　_defStyleRes_：这个也是指向一个Style的资源ID，但是仅在defStyleAttr为0或defStyleAttr不为0但Theme中没有为
　　　　
　　　　defStyleAttr属性赋值时起作用

　　　　优先级从高到低依次是：

　　　　直接在XML中定义 > xml中style定义 > 由defStyleAttr指定默认值 > defStyleRes指定默认值 > 直接在Theme中指定的值


参考:
http://www.cnblogs.com/angeldevil/p/3479431.html