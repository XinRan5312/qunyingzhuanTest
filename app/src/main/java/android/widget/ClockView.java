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
        //�Ȼ�Բ
        Paint paintCircle = new Paint(Color.BLACK);
        paintCircle.setAntiAlias(true);
        paintCircle.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mWidth / 2, paintCircle);
        //���̶�
        Paint paintDegree = new Paint(Color.BLACK);
        paintDegree.setStrokeWidth(3);
        for (int i = 0; i < 24; i++) {
            if (i == 0 || i == 6 || i == 12 || i == 18) {
                //����0,6,12,18�Ŀ̶���
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 60, paintDegree);
                paintDegree.setTextSize(30);
                //������
                canvas.drawText(String.valueOf(i), mWidth / 2 - paintDegree.measureText(String.valueOf(i)) / 2, mHeight / 2 - mWidth / 2 + 90, paintDegree);
            } else {
                //ͬ�� ֻ����С�ߺ�����Ĵ�С
                canvas.drawLine(mWidth / 2, mHeight / 2 - mWidth / 2, mWidth / 2, mHeight / 2 - mWidth / 2 + 30, paintDegree);
                paintDegree.setTextSize(15);
                canvas.drawText(String.valueOf(i), mWidth / 2 - paintDegree.measureText(String.valueOf(i)) / 2, mHeight / 2 - mWidth / 2 + 45, paintDegree);
            }
            //�����ĵ���ת15�� �Ӷ�����������
            canvas.rotate(15, mWidth / 2, mHeight / 2);
        }
        //��ָ��
        Paint paintHour=new Paint(Color.BLACK);
        paintHour.setStrokeWidth(20);
        Paint paintMin=new Paint(Color.BLACK);
        paintMin.setStrokeWidth(10);
        //���滭����ǰ��״̬�������Ĳ����൱�������½���ͼ���Ͻ��е�
        canvas.save();
        //��ԭ���ƶ��� Բ���ģ������ڵ�Բ����Ϊxy�����ԭ��
        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawLine(0,0,100,100,paintHour);
        canvas.drawLine(0,0,100,200,paintMin);
        //���½���ͼ����֮ǰͼ��ϲ�
        canvas.restore();
    }
}
