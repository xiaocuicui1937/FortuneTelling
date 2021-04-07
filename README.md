# FortuneTelling
仿文墨天机命盘界面，自定义view
宫格实现是通过drawline画直线，拿到View的width和height的1/4，按照对应宫格宽度和高度进行偏移划线；因为中间的是占了4个小宫格矩形位置组成的大宫格矩形，因此需要分部分处理，观察图形后发现按照从上到下分为4部分最为合适，最上边申、酉、戌、亥四个宫位划分为TopTopArea,中上部分的未、子两个宫位划分为TopCenterArea，中下部分的午、丑两个宫位分为BottomCenterArea，最下边巳、辰、卯、寅四个宫位划分为BottomBottomArea。
x方向也是屏幕宽度方向，按照宫格所占宽度划线偏移。y方向也就是屏幕高度方向，从上往下按照宫格所占高度偏移划线。
宫格中的文字部分，按照申宫调用drawText绘制出文字，并通过Paint设置文字的大小，文字的位置，以及文字的颜色，酉、戌、亥宫中的文字布局位置通过申宫中的文字位置按照宫位所处的位置偏移即可，其它宫位原理亦如此，具体查看demo中的代码实现。

中宫需要注意的是它会有多行文字的显示，但是drawText 只能实现单行文字效果，那么要想实现多行代码效果，需要用到官方提供另外一个专门用来实现多行文字的函数StaticLayout，我们要展示的数据 
val centerStrFromText ="姓名：匿名   ${info.性别} ${info.五行局}\n" + "真太阳时:${info.真太阳时}\n" + "钟表时间:${info.钟表时间}\n" + "农历:${info.年干}" + "${info.年支}年${info.农历月}月${info.农历日}日 ${info.时干}\n" + "命主:${info.命主} 身主:${info.身主}  子斗:${info.身宫}\n"]
 val centerStaticLayout = StaticLayout(centerStrFromText,mTextPaint,600,Layout.Alignment.ALIGN_NORMAL,1f,0f,true)

StaticLayout(CharSequence source, TextPaint paint, int width, Layout.Alignment align, float spacingmult, float spacingadd, boolean includepad)
width 是文字区域的宽度，文字到达这个宽度后就会自动换行；
align 是文字的对齐方向；
spacingmult 是行间距的倍数，通常情况下填 1 就好；
spacingadd 是行间距的额外增加值，通常情况下填 0 就好；
includepad 是指是否在文字上下添加额外的空间，来避免某些过高的字符的绘制出现越界。
多行文字偏移，需要配合canvas的translate方法实现，调用StaticLayout的draw方法进行绘制

添加点击事件，重写onTouchEvent方法，在 MotionEvent.ACTION_UP中判断用户点击位置是不是符合所在宫位的范围内如果是改变字体颜色，调用invalidate重新绘制其它宫位显示

<img src="https://github.com/xiaocuicui1937/FortuneTelling/blob/master/image-folder/Screenshot_20210322-200303.jpg" width="360" height="700" alt="实现效果1"/>         <img src="https://github.com/xiaocuicui1937/FortuneTelling/blob/master/image-folder/%E5%8A%A0%E5%AE%AB%E5%90%8D%E7%A7%B0.png" width="360" height="700" alt="实现效果2"/>

