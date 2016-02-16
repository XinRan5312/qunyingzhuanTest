package av.xxx.qunyingzhuantest.fragmentForCh5;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import av.xxx.qunyingzhuantest.R;


public class ViewDragFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_view_drag, container, false);
    }

}
