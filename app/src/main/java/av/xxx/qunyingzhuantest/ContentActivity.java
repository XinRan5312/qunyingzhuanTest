package av.xxx.qunyingzhuantest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import av.xxx.qunyingzhuantest.fragment.ChangeFocusFragment;
import av.xxx.qunyingzhuantest.fragment.ChatListViewFragment;
import av.xxx.qunyingzhuantest.fragment.HideToolbarFragment;
import av.xxx.qunyingzhuantest.fragment.OverDistanceFragment;


public class ContentActivity extends AppCompatActivity {
    private static final String INTENT_ID = "id";

    public static void comeToMe(Activity activity, int id) {
        Intent intent = new Intent(activity, ContentActivity.class);
        intent.putExtra(INTENT_ID, id);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        switch (getIntent().getIntExtra(INTENT_ID, 0)) {
            case 1:
                HideToolbarFragment fragment1 = new HideToolbarFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment1).commit();
                break;
            case 2:
                ChatListViewFragment fragment2 = new ChatListViewFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment2).commit();
                break;
            case 3:
                OverDistanceFragment fragment3 = new OverDistanceFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment3).commit();
                break;
            case 4:
                ChangeFocusFragment fragment4 = new ChangeFocusFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment4).commit();
                break;
        }

    }


}
