package com.cs591.w5_p1;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment {


    private EditText edtMessage;
    private Button btnSend;

    public MsgFragment() {
        // Required empty public constructor
    }

    // need to create interface to ensure message passing
    public interface ControlFragmentListener {
        public void sendMessage(String msg);
    }

    ControlFragmentListener CFL;

    // instantiate ControlFragmentListener in onAttach because we know MainActivity was successfully created and hooked
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_msg, container, false);

        edtMessage = (EditText) view.findViewById(R.id.edtMessage);
        btnSend = (Button) view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                CFL.sendMessage(edtMessage.getText().toString());
            }
        });

        return view;
    }

}
