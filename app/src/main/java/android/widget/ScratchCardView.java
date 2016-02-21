package android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import av.xxx.qunyingzhuantest.R;

/**
 * Created by 1 on 2016/2/18.
 */
public class ScratchCardView extends View {
    private Bitmap mBg, mFg;
    private Paint mPaint;
    private Canvas mCanvas;
    private Path mPath;

    public ScratchCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScratchCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ScratchCardView(Context context) {
        super(context);
        init();
    }

    private void init() {
        //��ʼ������
        mPaint = new Paint();
        //����͸����Ϊ0,��ΪxfermodeҲ���͸���ȼ����ȥ
        mPaint.setAlpha(0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        //������������������Ϊ�������ıʴ������Ӵ�����Բ��һЩ, ��Ҳ���Գ�����ע�͵������д����Ч��
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);
        mPath = new Path();
        //��ʼ������ͼ
        mBg = BitmapFactory.decodeResource(getResources(), R.mipmap.image_sea);
        //��ʼ��ǰ��ͼ
        mFg = Bitmap.createBitmap(mBg.getWidth(), mBg.getHeight(), Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mFg);
        mCanvas.drawColor(Color.GRAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(),event.getY());
                break;
        }

        mCanvas.drawPath(mPath,mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBg, 0, 0, null);
        canvas.drawBitmap(mFg, 0, 0, null);
    }
}
