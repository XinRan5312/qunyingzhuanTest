package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;

/**
 * Created by 1 on 2016/1/20.
 */
public class OverDistanceListView extends ListView {
    public OverDistanceListView(Context context) {
        this(context, null);
    }


    public OverDistanceListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public OverDistanceListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private int mMaxOverDistance = 20;

    private void initView(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        mMaxOverDistance = (int) (density * mMaxOverDistance);
    }


    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX,
                mMaxOverDistance, isTouchEvent);
    }

}
