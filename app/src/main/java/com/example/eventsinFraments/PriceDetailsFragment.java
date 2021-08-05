package com.example.eventsinFraments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class PriceDetailsFragment extends Fragment {
    private EditText etCurrency, etPrice;
    private Button btnnext;
    private CommunicationListenner listenner;
    private String tittle, description, startdate, enddate, starttime, endtime;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tittle = getArguments().getString("tittle");
            description = getArguments().getString("description");
            startdate = getArguments().getString("startdate");
            enddate = getArguments().getString("enddate");
            starttime = getArguments().getString("starttime");
            endtime = getArguments().getString("endtime");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
        etCurrency = view.findViewById(R.id.etCurrency);
        etPrice = view.findViewById(R.id.etPrice);
        btnnext = view.findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Currency = etCurrency.getText().toString();
                String Price = etPrice.getText().toString();

                Model model = new Model(tittle, description, startdate, enddate, starttime, endtime, Currency, Price);
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("model",model);
                startActivity(intent);
            }
        });
    }
}