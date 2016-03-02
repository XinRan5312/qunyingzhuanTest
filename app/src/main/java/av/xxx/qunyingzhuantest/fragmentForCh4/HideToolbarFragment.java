package av.xxx.qunyingzhuantest.fragmentForCh4;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class HideToolbarFragment extends Fragment {
    @Bind(R.id.tool_bar)
     Toolbar mToolbar;
    @Bind(R.id.lv)
     ListView mListView;
    private String[] mStr = new String[20];
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =View .inflate(getActivity(), R.layout.fragment_hide_toolbar,null);
        ButterKnife.bind(this, view);
        mTouchSlop = ViewConfiguration.get(getActivity()).getScaledTouchSlop();

        for (int i = 0; i < mStr.length; i++) {
            mStr[i] = "Item " + i;
        }
        View header = new View(getActivity());
        header.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT,
                (int) getResources().getDimension(R.dimen.abc_action_bar_default_height_material)));
        mListView.addHeaderView(header);
        mListView.setAdapter(new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mStr));
        mListView.setOnTouchListener(myTouchListener);

        return view;
    }



    View.OnTouchListener myTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop) {
                        direction = 0;// down
                    } else if (mFirstY - mCurrentY > mTouchSlop) {
                        direction = 1;// up
                    }
                    if (direction == 1) {
                        if (mShow) {
                            toolbarAnim(1);//show
                            mShow = !mShow;
                        }
                    } else if (direction == 0) {
                        if (!mShow) {
                            toolbarAnim(0);//hide
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };



    private void toolbarAnim(int flag) {
        if (mAnimator != null && mAnimator.isRunning()) {
            mAnimator.cancel();
        }
        if (flag == 0) {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(), 0);
        } else {
            mAnimator = ObjectAnimator.ofFloat(mToolbar, "translationY", mToolbar.getTranslationY(), -mToolbar.getHeight());
        }
        mAnimator.start();
    }
}
