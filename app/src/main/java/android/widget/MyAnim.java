package android.widget;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by 1 on 2016/2/28.
 */
public class MyAnim extends Animation {

    private int mWidth;
    private int mHeight;


    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mWidth = width;
        mHeight = height;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        final Matrix matrix = t.getMatrix();
        matrix.preScale(1, 1 - interpolatedTime, mWidth / 2, mHeight / 2);


    }
}
