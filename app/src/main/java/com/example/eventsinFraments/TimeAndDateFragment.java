package com.example.eventsinFraments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TimeAndDateFragment extends Fragment {

    private EditText etstartdate,etenddate,etstarttime,etendtime;
    private Button btnnext;
    private CommunicationListenner listenner;
    private String tittle;
    private String description;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenner = (CommunicationListenner) context;
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            tittle = getArguments().getString("tittle");
            description = getArguments().getString("description");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);

    }

    private void initviews(View view) {
        etstartdate = view.findViewById(R.id.etstartdate);
        etenddate = view.findViewById(R.id.etenddate);
        etstarttime = view.findViewById(R.id.etstarttime);
        etendtime = view.findViewById(R.id.etendtime);
        btnnext = view.findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String startdate = etstartdate.getText().toString();
                String enddate = etenddate.getText().toString();
                String starttime = etstarttime.getText().toString();
                String endtime = etendtime.getText().toString();
                tittle = getArguments().getString("tittle");
                description = getArguments().getString("description");
                bundle.putString("startdate",startdate);
                bundle.putString("enddate",enddate);
                bundle.putString("starttime",starttime);
                bundle.putString("endtime",endtime);
                bundle.putString("tittle",tittle);
                bundle.putString("description",description);

                if(listenner!=null){
                    listenner.launchPriceDetailsFragment(bundle);
                }
            }
        });
    }
}