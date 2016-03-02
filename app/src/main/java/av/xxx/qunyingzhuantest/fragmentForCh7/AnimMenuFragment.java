package av.xxx.qunyingzhuantest.fragmentForCh7;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnimMenuFragment extends Fragment {
    @Bind(R.id.iv_0)
    ImageView iv0;
    @Bind(R.id.iv_1)
    ImageView iv1;
    @Bind(R.id.iv_2)
    ImageView iv2;
    @Bind(R.id.iv_3)
    ImageView iv3;
    @Bind(R.id.iv_4)
    ImageView iv4;

    private boolean mFlag=true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anim2, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        iv0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFlag) {
                    startAnim();
                } else {
                    closeAnim();
                }
            }
        });


    }

    private void startAnim() {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(iv0, "alpha", 1f, 0.5f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(iv1, "translationX", 200f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(iv2, "translationX", -200f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(iv3, "translationY", 200f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(iv4, "translationY", -200f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(objectAnimator0, objectAnimator1, objectAnimator2, objectAnimator3, objectAnimator4);
        set.start();
        mFlag = false;
    }

    private void closeAnim() {
        ObjectAnimator objectAnimator0 = ObjectAnimator.ofFloat(iv0, "alpha", 0.5f, 1f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(iv1, "translationX", 0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(iv2, "translationX", 0f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(iv3, "translationY", 0f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(iv4, "translationY", 0f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(500);
        set.setInterpolator(new BounceInterpolator());
        set.playTogether(objectAnimator0, objectAnimator1, objectAnimator2, objectAnimator3, objectAnimator4);
        set.start();
        mFlag = true;
    }
}
