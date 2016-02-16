package av.xxx.qunyingzhuantest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import av.xxx.qunyingzhuantest.fragmentForCh4.ChangeFocusFragment;
import av.xxx.qunyingzhuantest.fragmentForCh4.ChatListViewFragment;
import av.xxx.qunyingzhuantest.fragmentForCh4.HideToolbarFragment;
import av.xxx.qunyingzhuantest.fragmentForCh4.OverDistanceFragment;
import av.xxx.qunyingzhuantest.fragmentForCh5.ViewDragFragment;
import av.xxx.qunyingzhuantest.fragmentForCh6.ClockViewFragment;


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
            case 5:
                ViewDragFragment fragment5 = new ViewDragFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment5).commit();
                break;
            case 6:
                ClockViewFragment fragment6 = new ClockViewFragment();
                getFragmentManager().beginTransaction().replace(R.id.rl_main, fragment6).commit();
                break;
        }

    }


}
