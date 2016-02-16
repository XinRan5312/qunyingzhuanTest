package av.xxx.qunyingzhuantest.fragmentForCh4;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ChangeFocusFragment extends Fragment {
    @Bind(R.id.lv)
    ListView mListView;
    List<String> mList = new ArrayList<>();
    ChangeFocusAdapter mChangeFocusAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_change_focus, null);
        ButterKnife.bind(this, view);
        mChangeFocusAdapter=new ChangeFocusAdapter();
        mListView.setAdapter(mChangeFocusAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mChangeFocusAdapter.setCurrentItem(position);
                mChangeFocusAdapter.notifyDataSetChanged();
            }
        });

        for (int i =0;i<10;i++){
            mList.add("item "+i);
        }

        return view;
    }


    private class ChangeFocusAdapter extends BaseAdapter {

        private int currentItem=0;


        public void setCurrentItem(int currentItem) {
            this.currentItem = currentItem;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout layout = new LinearLayout(getActivity());
            layout.setOrientation(LinearLayout.VERTICAL);

            if(currentItem==position){
                layout.addView(addFocusView());
            }else{
                layout.addView(addNormalView(position));
            }

            return layout;
        }
    }

    private View addFocusView() {
        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.mipmap.head1);
        return iv;
    }

    private View addNormalView(int position) {
        TextView tv=new TextView(getActivity());
        tv.setTextSize(40);
        tv.setText(mList.get(position));
        return tv;
    }

}
