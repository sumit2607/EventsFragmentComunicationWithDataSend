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


public class EventDetailsFragment extends Fragment {

    private EditText ettittle, etdescripiton;
    private Button btnnext;
    private CommunicationListenner listenner;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenner = (CommunicationListenner) context;

    }

    private void initViews(View view) {
        ettittle = view.findViewById(R.id.ettittle);
        etdescripiton = view.findViewById(R.id.etdescripiton);
        btnnext = view.findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String tittle = ettittle.getText().toString();
                String description = etdescripiton.getText().toString();
                bundle.putString("tittle", tittle);
                bundle.putString("description", description);
                
                if (listenner != null) {
                    listenner.launchTimeAndDateFragment(bundle);
                }
            }
        });
    }
}