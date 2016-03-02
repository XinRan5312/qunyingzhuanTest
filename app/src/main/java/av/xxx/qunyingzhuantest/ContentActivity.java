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
import av.xxx.qunyingzhuantest.fragmentForCh6.ColorMatrixFragment;
import av.xxx.qunyingzhuantest.fragmentForCh6.ScratchCardFragment;
import av.xxx.qunyingzhuantest.fragmentForCh6.SurfaceViewFragment;
import av.xxx.qunyingzhuantest.fragmentForCh7.AnimDropFragment;
import av.xxx.qunyingzhuantest.fragmentForCh7.AnimFragment;
import av.xxx.qunyingzhuantest.fragmentForCh7.AnimMenuFragment;


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
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment1).commit();
                break;
            case 2:
                ChatListViewFragment fragment2 = new ChatListViewFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment2).commit();
                break;
            case 3:
                OverDistanceFragment fragment3 = new OverDistanceFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment3).commit();
                break;
            case 4:
                ChangeFocusFragment fragment4 = new ChangeFocusFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment4).commit();
                break;
            case 5:
                ViewDragFragment fragment5 = new ViewDragFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment5).commit();
                break;
            case 6:
                ClockViewFragment fragment6 = new ClockViewFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment6).commit();
                break;
            case 7:
                ColorMatrixFragment fragment7 = new ColorMatrixFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment7).commit();
                break;
            case 8:
                ScratchCardFragment fragment8 = new ScratchCardFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment8).commit();
                break;
            case 9:
                SurfaceViewFragment fragment9 = new SurfaceViewFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment9).commit();
                break;
            case 10:
                AnimFragment fragment10 = new AnimFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment10).commit();
                break;
            case 11:
                AnimMenuFragment fragment11 = new AnimMenuFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment11).commit();
                break;
            case 12:
                AnimDropFragment fragment12 = new AnimDropFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.rl_main, fragment12).commit();
                break;
        }

    }


}
