package av.xxx.qunyingzhuantest.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import av.xxx.qunyingzhuantest.Bean.ChatBean;
import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class ChatListViewFragment extends Fragment {
    @Bind(R.id.lv)
    ListView mListView;
    private ChatAdapter mChatAdapter;
    private List<ChatBean> mChatBeanList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = View.inflate(getActivity(), R.layout.fragment_chat_list_view, null);
        ButterKnife.bind(this, view);
        mChatAdapter = new ChatAdapter();
        mListView.setAdapter(mChatAdapter);
        initBean();
        return view;
    }

    private void initBean() {


        ChatBean chatBean1 = new ChatBean(1, "hi");

        ChatBean chatBean2 = new ChatBean(0, "hi");

        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                mChatBeanList.add(chatBean1);
            } else {
                mChatBeanList.add(chatBean2);
            }
        }

    }


    private class ChatAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mChatBeanList.size();
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
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return mChatBeanList.get(position).getType();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            ChatBean chatBean = mChatBeanList.get(position);
            if (convertView == null) {
                viewHolder = new ViewHolder();
                if (getItemViewType(position) == 0) {//不重写方法直接用ChatBean里的type比较也一样
                    convertView = View.inflate(getActivity(), R.layout.chat_item_in, null);
                    viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_in_text);
                } else {
                    convertView = View.inflate(getActivity(), R.layout.chat_item_out, null);
                    viewHolder.tv = (TextView) convertView.findViewById(R.id.tv_out_text);
                }
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tv.setText(chatBean.getText());


            return convertView;
        }

        class ViewHolder {

            TextView tv;

        }

    }

}
