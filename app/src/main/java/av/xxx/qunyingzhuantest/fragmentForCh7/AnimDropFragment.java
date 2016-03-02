package av.xxx.qunyingzhuantest.fragmentForCh7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class AnimDropFragment extends Fragment {

    @Bind(R.id.ll)
    LinearLayout mClickMe;
    @Bind(R.id.hide)
    LinearLayout mHide;

    private float mDensity;

    private int mHideHeight;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_anim_drop, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //获取像素密度
        mDensity = getResources().getDisplayMetrics().density;
        mHideHeight = (int) (mDensity * 40 + 0.5);
        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mHide.getVisibility() == View.GONE) {
                    animOpen(mHide);
                } else {
                    animClose(mHide);
                }
            }
        });
    }


    private void animClose(final View view) {

        Animator animator = createDropAnim(view, view.getHeight(), 0);

        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }
        });

        animator.start();
    }


    private void animOpen(View view) {
        view.setVisibility(View.VISIBLE);
        createDropAnim(view, 0, mHideHeight).start();
    }


    private ValueAnimator createDropAnim(final View view, int start, int end) {

        final ValueAnimator valueAnimator = ValueAnimator.ofInt(start, end);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int value = (int) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);

            }
        });

        return valueAnimator;
    }
}
