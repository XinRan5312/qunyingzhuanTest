package android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 1 on 2016/2/11.
 */
public class ClockView extends View {
    private int mWidth;
    private int mHeight;


    public ClockView(Context context) {
        super(context);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mHeight = getHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //先画圆
        Paint paintCircle = new Paint(Color.BLACK);
        paintCircle.setAntiAlias(true);
        paintCircle.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, paintCircle);
        //画刻度
        Paint paintDegree = new Paint(Color.BLACK);
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                //画出0,6,12,18的刻度线
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 60, paintDegree);
                paintDegree.setTextSize(30);
                //画出字
                canvas.drawText(String.valueOf(i), mWidth / 2 - paintDegree.measureText(String.valueOf(i)) / 2, mHeight / 2 - mWidth / 2 + 90, paintDegree);
            } else {
                //同上 只是缩小线和字体的大小
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 30, paintDegree);
                paintDegree.setTextSize(15);
                canvas.drawText(String.valueOf(i), mWidth / 2 - paintDegree.measureText(String.valueOf(i)) / 2, mHeight / 2 - mWidth / 2 + 45, paintDegree);
            }
            //以中心点旋转15度 从而简化坐标运算
            canvas.rotate(15, mWidth / 2, mHeight / 2);
        }
        //画指针
        Paint paintHour=new Paint(Color.BLACK);
        paintHour.setStrokeWidth(20);
        Paint paintMin=new Paint(Color.BLACK);
        paintMin.setStrokeWidth(10);
        //保存画布当前的状态，保存后的操作相当于是在新建的图层上进行的
        canvas.save();
        //将原点移动到 圆中心，即现在的圆中心为xy坐标的原点
        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMin);
        //将新建的图层与之前图层合并
        canvas.restore();
    }
}
