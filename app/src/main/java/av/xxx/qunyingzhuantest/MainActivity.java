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
            case R.id.btn_1:
                ContentActivity.comeToMe(MainActivity.this,1);
                break;
            case R.id.btn_2:
                ContentActivity.comeToMe(MainActivity.this,2);
                break;
            case R.id.btn_3:
                ContentActivity.comeToMe(MainActivity.this,3);
                break;
            case R.id.btn_4:
                ContentActivity.comeToMe(MainActivity.this,4);
                break;
        }
    }
}