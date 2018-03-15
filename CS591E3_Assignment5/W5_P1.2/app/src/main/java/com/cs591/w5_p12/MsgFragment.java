package com.cs591.w5_p12;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MsgFragment extends Fragment {


    //private EditText edtMessage;
    private ListView lvMessages;
    private Button btnSend;
    private String sentMsg;
    private int bgPos;

    public MsgFragment() {
        // Required empty public constructor
    }

    // need to create interface to ensure message passing
    public interface ControlFragmentListener {
        public void sendMessage(String msg);
        public void setBG(int bgPosition);
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

        //edtMessage = (EditText) view.findViewById(R.id.edtMessage);
        lvMessages = (ListView) view.findViewById(R.id.lvMessages);
        btnSend = (Button) view.findViewById(R.id.btnSend);

        // create adapter to bind array to ListView
        final String[] messages = {"Cheeseburgers are good.",
                                   "Hot dogs are good.",
                                   "Pizza is good.",
                                   "French fries are good.",
                                   "Fried ice cream is good."};
        ArrayAdapter messageListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, messages);

        // set adapter to list view
        lvMessages.setAdapter(messageListAdapter);

        // set on click listener for list view
        lvMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sentMsg = String.valueOf(parent.getItemAtPosition(position));
                bgPos = position;
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                CFL.sendMessage(sentMsg);
                CFL.setBG(bgPos);
            }
        });

        return view;
    }



}
