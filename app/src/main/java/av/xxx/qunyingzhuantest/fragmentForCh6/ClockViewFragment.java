package av.xxx.qunyingzhuantest.fragmentForCh6;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import av.xxx.qunyingzhuantest.R;


public class ClockViewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_clock_view, container, false);
    }


}
