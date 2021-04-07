package com.gnss.fortunetelling

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Align
import android.graphics.Rect
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.text.TextUtils
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.gnss.fortunetelling.bean.ListBean

class MingPanView @JvmOverloads constructor(context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : View(context, attrs, defStyleAttr) {
    private var mPaintLine = Paint()
    private val mTextPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    private var mColor:Int=Color.RED
    private var isClick:Boolean= true
    init {
        init()
    }

    private fun init() {

        //加载文本数据
        JsonParser.jsonParseWithSrc()
        initPaintWithLineAndAppName()

    }

    private fun initPaintWithLineAndAppName() {
        mPaintLine.color = Color.BLACK
        mPaintLine.strokeWidth = 1f.dp
    }

    private fun setTextPaint(align: Align, color: Int, size: Float, isBold: Boolean) {
        mTextPaint.textAlign = align
        if (color != 0) {
            mTextPaint.color = color
        }
        mTextPaint.textSize = size
        mTextPaint.isFakeBoldText = isBold
    }

    //TODO 新增点击事件 通过动态设置文字需要展示颜色，重新绘制从而改变了颜色
    override fun onTouchEvent(event: MotionEvent): Boolean {
        //左边第一条竖线的横坐标x
        val width = width
        val lineVerticalLeftX = width / 4
        val lineVerticalRightX = 3 * lineVerticalLeftX
        val lineVerticalCenterX = 2 * lineVerticalLeftX
        //上边第一台一条横线的纵坐标y
        val height = height
        val lineHorizontalTopY = height / 4
        val lineHorizontalCenterY = 2 * lineHorizontalTopY
        val lineHorizontalBottomY = 3 * lineHorizontalTopY
        val rawX = event.x
        val rawY = event.y

        when(event.actionMasked){
            MotionEvent.ACTION_UP -> {
                //申位
                if (rawX>0&&rawX<lineVerticalLeftX&&rawY>0&&rawY<lineHorizontalTopY){
                    "点击了申位置".showToast()
                    mColor = if (isClick){
                        Color.GREEN
                    }else{
                        Color.RED
                    }
                    isClick = !isClick

                    invalidate()
                    return true
                }
            }
        }
        return super.onTouchEvent(event)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //左边第一条竖线的横坐标x
        val width = width
        val lineVerticalLeftX = width / 4
        val lineVerticalRightX = 3 * lineVerticalLeftX
        val lineVerticalCenterX = 2 * lineVerticalLeftX
        //上边第一台一条横线的纵坐标y
        val height = height
        val lineHorizontalTopY = height / 4
        val lineHorizontalCenterY = 2 * lineHorizontalTopY
        val lineHorizontalBottomY = 3 * lineHorizontalTopY
        //vertical
        drawVerticalLines(canvas,
            lineVerticalLeftX,
            lineVerticalRightX,
            lineVerticalCenterX,
            height,
            lineHorizontalTopY,
            lineHorizontalBottomY)
        //horizontal
        drawHorizontalLines(canvas,
            width,
            lineVerticalLeftX,
            lineVerticalRightX,
            height,
            lineHorizontalTopY,
            lineHorizontalCenterY,
            lineHorizontalBottomY)

        //center text show
        centerStr(canvas, width.toFloat(), lineHorizontalTopY)

        //top top left show-----------------------------
        drawArea(canvas, 0f, 0f, lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadShen())
        drawArea(canvas, lineVerticalLeftX.toFloat(), 0f, lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadYou(),mColor)
        drawArea(canvas, lineVerticalCenterX.toFloat(), 0f, lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadXu())
        drawArea(canvas, lineVerticalRightX.toFloat(), 0f, lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadHai())
        //        second
        drawArea(canvas, 0f, lineHorizontalTopY.toFloat(), lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadWei())
        drawArea(canvas, lineVerticalRightX.toFloat(), lineHorizontalTopY.toFloat(), lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadZi())
        //thrid
        drawArea(canvas, 0f, lineHorizontalCenterY.toFloat(), lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadWu())
        drawArea(canvas,
            lineVerticalRightX.toFloat(),
            lineHorizontalCenterY.toFloat(),
            lineHorizontalTopY,
            lineVerticalLeftX,JsonParser.loadChou())
        //four
        drawArea(canvas, 0f, lineHorizontalBottomY.toFloat(), lineHorizontalTopY, lineVerticalLeftX,JsonParser.loadSi())
        drawArea(canvas,
            lineVerticalLeftX.toFloat(),
            lineHorizontalBottomY.toFloat(),
            lineHorizontalTopY,
            lineVerticalLeftX,JsonParser.loadChen())
        drawArea(canvas,
            lineVerticalCenterX.toFloat(),
            lineHorizontalBottomY.toFloat(),
            lineHorizontalTopY,
            lineVerticalLeftX,JsonParser.loadMao())
        drawArea(canvas,
            lineVerticalRightX.toFloat(),
            lineHorizontalBottomY.toFloat(),
            lineHorizontalTopY,
            lineVerticalLeftX,JsonParser.loadYin())
        //------------------------------------end-----------------
    }

    private fun drawArea(canvas: Canvas, offsetX: Float, offsetY: Float, lineHorizontalTopY: Int, lineVerticalLeftX: Int,json:ListBean,color:Int=Color.RED) {

        setTextPaint(Align.CENTER, Color.RED, 12f.dp, true)
        val width = mTextPaint.measureText("耗")

        for (index in json.stars.indices){
            val star = json.stars[index]
            val ws = width * index
            drawAreaTop(canvas, star.big, star.small, offsetX+ws, offsetY, color)
        }
        //bottom left show
        drawAreaBottomLeft(canvas, json.bottomLeft.toTypedArray(), offsetX, offsetY, lineHorizontalTopY)
        // bottom right show
        val widthS: Float = drawAreaBottomRight(canvas, json.bottomRight.toTypedArray(), offsetX, offsetY, lineVerticalLeftX, lineHorizontalTopY)
        //bottom center
        drawAreaBottomCenter(canvas, json.bottomCenter.toTypedArray(), offsetX, offsetY, lineVerticalLeftX, widthS, lineHorizontalTopY)
        //center
        drawAreaCenter(canvas, json.center, offsetX, offsetY, lineVerticalLeftX, lineHorizontalTopY)
    }


    private fun drawAreaCenter(canvas: Canvas,
        content: String,
        offsetX: Float,
        offsetY: Float,
        lineVerticalLeftX: Int,
        lineHorizontalTopY: Int) {
        setTextPaint(Align.CENTER, Color.GRAY, 8f.dp, true)
        val centerStaticLayout = StaticLayout(content, mTextPaint, 100,
            Layout.Alignment.ALIGN_CENTER, 1f, 0f, true)
//        canvas.drawText(content, lineVerticalLeftX / 2f + paddingStart + offsetX,
//            lineHorizontalTopY / 1.8f + paddingTop + offsetY, mTextPaint)
        canvas.save()
        canvas.translate(lineVerticalLeftX / 2.5f+ offsetX, lineHorizontalTopY / 2.5f + offsetY)
        centerStaticLayout.draw(canvas)
        canvas.restore()
    }

    private fun drawAreaBottomCenter(canvas: Canvas,
        strs: Array<String>,
        offsetX: Float,
        offsetY: Float,
        lineVerticalLeftX: Int,
        widthS: Float,
        lineHorizontalTopY: Int) {
        setTextPaint(Align.CENTER, Color.GRAY, 12f.dp, true)
        canvas.drawText(strs[0],
            lineVerticalLeftX - widthS * 4 + paddingStart + offsetX,
            lineHorizontalTopY - getTextHeight("耗", mTextPaint) / 2f + paddingTop + offsetY,
            mTextPaint)
        canvas.drawText(strs[1],
            lineVerticalLeftX - widthS * 4.8f + paddingStart + offsetX,
            lineHorizontalTopY - getTextHeight("耗", mTextPaint) * 2.8f + paddingTop + offsetY,
            mTextPaint)
    }

    private fun drawAreaBottomRight(canvas: Canvas,
        strs: Array<String>,
        offsetX: Float,
        offsetY: Float,
        lineVerticalLeftX: Int,
        lineHorizontalTopY: Int): Float {
        val l = "耗"
        val widthS: Float = mTextPaint.measureText(l)
        drawVerticalTextTop(canvas,
            strs[0],
            "",
            lineVerticalLeftX - widthS + offsetX,
            lineHorizontalTopY - getTextHeight(l, mTextPaint) * 2f + paddingTop + offsetY,
            Color.GREEN,
            0,
            12f.dp,
            0f)
        setTextPaint(Align.CENTER, Color.GRAY,  12f.dp, true)
        canvas.drawText(strs[1],lineVerticalLeftX - widthS*1.8f + offsetX,
            lineHorizontalTopY - getTextHeight(l, mTextPaint) * 4f + paddingTop + offsetY,mTextPaint)
//        drawVerticalTextTop(canvas,
//            strs[1],
//            "",
//            lineVerticalLeftX - widthS + offsetX,
//            lineHorizontalTopY - getTextHeight(l, mTextPaint) * 3f + paddingTop + offsetY,
//            Color.GRAY,
//            0,
//            12f.dp,
//            0f)
        return widthS
    }

    private fun drawAreaBottomLeft(canvas: Canvas,
        strs: Array<String>,
        offsetX: Float,
        offsetY: Float,
        lineHorizontalTopY: Int) {
        setTextPaint(Align.CENTER, Color.GRAY, 8f.dp, true)
        canvas.drawText(strs[0],
            10f.dp + paddingStart + offsetX,
            +lineHorizontalTopY - getTextHeight("耗", mTextPaint) / 2f + paddingTop + offsetY,
            mTextPaint)
        canvas.drawText(strs[1],
            10f.dp + paddingStart + offsetX,
            lineHorizontalTopY - getTextHeight("耗", mTextPaint) * 2f + paddingTop + offsetY,
            mTextPaint)
        setTextPaint(Align.CENTER, Color.BLUE, 8f.dp, true)
        canvas.drawText(strs[2],
            10f.dp + paddingStart + offsetX,
            lineHorizontalTopY - getTextHeight("耗", mTextPaint) * 3.5f + paddingTop + offsetY,
            mTextPaint)
    }

    private fun drawAreaTop(canvas: Canvas,
        content: String,
        small: String,
        offsetX: Float,
        offsetY: Float,
        contentColor: Int) {
        drawVerticalTextTop(canvas,
            content,
            small,
            offsetX + 10f.dp,
            offsetY + 16f.dp,
            contentColor,
            Color.GRAY,
            12f.dp,
            8f.dp)
    }

    private fun drawVerticalTextTop(canvas: Canvas,
        content: String,
        small: String,
        offsetX: Float,
        offsetY: Float,
        contentColor: Int,
        smallColor: Int,
        contentSize: Float,
        smallSize: Float) {
        setTextPaint(Align.CENTER, contentColor, contentSize, true)

        val chars = content.toCharArray()
        for (i in chars.indices) {
            canvas.drawText(chars[i].toString(),
                offsetX + paddingStart,
                if (i == 0) offsetY + paddingTop else offsetY + paddingTop + getTextHeight(content, mTextPaint), mTextPaint)
        }
        if (TextUtils.isEmpty(small)) {
            return
        }
        val textHeight = getTextHeight(content, mTextPaint)
        setTextPaint(Align.CENTER, smallColor, smallSize, true)
        canvas.drawText(small, offsetX, offsetY + paddingTop + 2 * textHeight, mTextPaint)
    }

    private fun centerStr(canvas: Canvas, width: Float, lineHorizontalTopY: Int) {
        setTextPaint(Align.CENTER, Color.BLACK, 16f.dp, true)
        val appName = resources.getString(R.string.app_name)
        canvas.drawText(appName,
            width / 2,
            lineHorizontalTopY + 10f.dp + getTextHeight(appName, mTextPaint).toFloat(),
            mTextPaint)
        setTextPaint(Align.CENTER, 0, 12f.dp, false)
        val info = JsonParser.mData.其他信息
        val centerStrFromText =
            "姓名：匿名   ${info.性别} ${info.五行局}\n" + "真太阳时:${info.真太阳时}\n" + "钟表时间:${info.钟表时间}\n" + "农历:${info.年干}" +
                    "${info.年支}年${info.农历月}月${info.农历日}日 ${info.时干}\n" + "命主:${info.命主} 身主:${info.身主}  子斗:${info.身宫}\n"
        val centerStaticLayout = StaticLayout(centerStrFromText,
            mTextPaint,
            600,
            Layout.Alignment.ALIGN_NORMAL,
            1f,
            0f,
            true)

        //移动字符介绍
        canvas.save()
        canvas.translate(width / 2,
            lineHorizontalTopY + 30f.dp + getTextHeight(appName, mTextPaint).toFloat())
        centerStaticLayout.draw(canvas)
        canvas.translate((-60f).dp, 80f.dp)
        setTextPaint(Align.LEFT, Color.BLACK, 16f.dp, true)

        val centerBig = "四化引动\n禄权科忌的\n变化，即时显示"
        val centerBigStaticLayout =
            StaticLayout(centerBig, mTextPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1.2f, 0f, true)
        centerBigStaticLayout.draw(canvas)

        canvas.translate(60f.dp, 100f.dp)
        setTextPaint(Align.CENTER, Color.GRAY, 10f.dp, true)
        val bottom = "自化图示—>禄—>权—>科—>忌"
        val bottomStaticLayout =
            StaticLayout(bottom, mTextPaint, 400, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
        bottomStaticLayout.draw(canvas)
        canvas.restore()
    }

    private fun getTextHeight(text: String, paint: Paint): Int {
        val rect = Rect()
        paint.getTextBounds(text, 0, text.length, rect)
        return rect.height()
    }

    private fun drawHorizontalLines(canvas: Canvas,
        width: Int,
        lineVerticalLeftX: Int,
        lineVerticalRightX: Int,
        height: Int,
        lineHorizontalTopY: Int,
        lineHorizontalCenterY: Int,
        lineHorizontalBottomY: Int) {
        canvas.drawLine(0f, 0f, width.toFloat(), 0f, mPaintLine)
        canvas.drawLine(0f,
            lineHorizontalTopY.toFloat(),
            width.toFloat(),
            lineHorizontalTopY.toFloat(),
            mPaintLine)
        //横向 最左边分割线
        canvas.drawLine(0f,
            lineHorizontalCenterY.toFloat(),
            lineVerticalLeftX.toFloat(),
            lineHorizontalCenterY.toFloat(),
            mPaintLine)
        //最右边分割线
        canvas.drawLine(lineVerticalRightX.toFloat(),
            lineHorizontalCenterY.toFloat(),
            width.toFloat(),
            lineHorizontalCenterY.toFloat(),
            mPaintLine)
        canvas.drawLine(0f,
            lineHorizontalBottomY.toFloat(),
            width.toFloat(),
            lineHorizontalBottomY.toFloat(),
            mPaintLine)
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), mPaintLine)
    }

    private fun drawVerticalLines(canvas: Canvas,
        lineVerticalLeftX: Int,
        lineVerticalRightX: Int,
        lineVerticalCenterX: Int,
        height: Int,
        lineHorizontalTopY: Int,
        lineHorizontalBottomY: Int) {
        canvas.drawLine(0f, 0f, 0f, height.toFloat(), mPaintLine)
        canvas.drawLine(lineVerticalLeftX.toFloat(),
            0f,
            lineVerticalLeftX.toFloat(),
            height.toFloat(),
            mPaintLine)
        //竖向线排列中间的一条top
        canvas.drawLine(lineVerticalCenterX.toFloat(),
            0f,
            lineVerticalCenterX.toFloat(),
            lineHorizontalTopY.toFloat(),
            mPaintLine)
        //竖向线排列中间的一条bottom
        canvas.drawLine(lineVerticalCenterX.toFloat(),
            lineHorizontalBottomY.toFloat(),
            lineVerticalCenterX.toFloat(),
            height.toFloat(),
            mPaintLine)
        canvas.drawLine(lineVerticalRightX.toFloat(),
            0f,
            lineVerticalRightX.toFloat(),
            height.toFloat(),
            mPaintLine)
        canvas.drawLine(width.toFloat(), 0f, width.toFloat(), height.toFloat(), mPaintLine)
    }


}