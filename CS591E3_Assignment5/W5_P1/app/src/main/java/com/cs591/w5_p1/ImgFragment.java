package com.cs591.w5_p1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImgFragment extends Fragment {

    private TextView tvMessage;

    public ImgFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_img, container, false);
        tvMessage = (TextView) view.findViewById(R.id.tvMessage);
        return view;
    }

    // receiving method, implemented in the main activity (not fragments)
    public void setMessage(String msg) {
        tvMessage.setText(msg);
    }

}
