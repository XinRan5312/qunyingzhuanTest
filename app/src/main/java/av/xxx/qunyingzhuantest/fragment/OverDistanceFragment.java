package av.xxx.qunyingzhuantest.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class OverDistanceFragment extends Fragment {
    @Bind(R.id.lv)
     ListView mListView;
    private String []mStr=new String[20];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =View.inflate(getActivity(),R.layout.fragment_over_distance,null);
        ButterKnife.bind(this,view);
        for (int i = 0; i < mStr.length; i++) {
            mStr[i] = "Item " + i;
        }
        mListView.setAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,mStr));


        return view;
    }


}
