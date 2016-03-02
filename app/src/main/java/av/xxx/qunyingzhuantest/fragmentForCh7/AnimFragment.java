package av.xxx.qunyingzhuantest.fragmentForCh7;

import android.support.v4.app.Fragment;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MyAnim;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 1 on 2016/2/29.
 */
public class AnimFragment extends Fragment {

    @Bind(R.id.iv)
    ImageView mImageView;

    @Bind(R.id.iv1)
    ImageView mImageView1;

    @Bind(R.id.iv2)
    ImageView mImageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_anim, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        MyAnim anim=new MyAnim();
        anim.setDuration(1000);
        anim.setFillAfter(true);
        mImageView.startAnimation(anim);

        ((Animatable)mImageView1.getDrawable()).start();
        ((Animatable)mImageView2.getDrawable()).start();

    }
}