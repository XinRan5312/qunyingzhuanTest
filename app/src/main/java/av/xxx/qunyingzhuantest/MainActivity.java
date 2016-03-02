package av.xxx.qunyingzhuantest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listview_1:
                ContentActivity.comeToMe(MainActivity.this,1);
                break;
            case R.id.btn_listview_2:
                ContentActivity.comeToMe(MainActivity.this,2);
                break;
            case R.id.btn_listview_3:
                ContentActivity.comeToMe(MainActivity.this,3);
                break;
            case R.id.btn_listview_4:
                ContentActivity.comeToMe(MainActivity.this,4);
                break;
            case R.id.btn_scroll_1:
                ContentActivity.comeToMe(MainActivity.this,5);
                break;
            case R.id.btn_draw_1:
                ContentActivity.comeToMe(MainActivity.this,6);
                break;
            case R.id.btn_draw_2:
                ContentActivity.comeToMe(MainActivity.this,7);
                break;
            case R.id.btn_draw_3:
                ContentActivity.comeToMe(MainActivity.this,8);
                break;
            case R.id.btn_draw_4:
                ContentActivity.comeToMe(MainActivity.this,9);
                break;
            case R.id.btn_anim_1:
                ContentActivity.comeToMe(MainActivity.this,10);
                break;
            case R.id.btn_anim_2:
                ContentActivity.comeToMe(MainActivity.this,11);
                break;
            case R.id.btn_anim_3:
                ContentActivity.comeToMe(MainActivity.this,12);
                break;
        }
    }
}