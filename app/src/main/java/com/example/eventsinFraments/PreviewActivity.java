package com.example.eventsinFraments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView tvtittle, tvdescription, tvstartdate, tvenddate, tvstarttime, tvendtime, tvcurrency, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initviews();
        getDatafromIntent();
    }

    private void initviews() {
        tvtittle = findViewById(R.id.tvtittle);
        tvdescription = findViewById(R.id.tvdescription);
        tvstartdate = findViewById(R.id.tvstartdate);
        tvenddate = findViewById(R.id.tvenddate);
        tvstarttime = findViewById(R.id.tvstarttime);
        tvendtime = findViewById(R.id.tvendtime);
        tvcurrency = findViewById(R.id.tvcurrency);
        tvPrice = findViewById(R.id.tvPrice);

    }

    public void getDatafromIntent() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        tvtittle.setText(model.getTittle());
        tvdescription.setText(model.getDescription());
        tvstartdate.setText(model.getStartdate());
        tvenddate.setText(model.getEnddate());
        tvstarttime.setText(model.getStarttime());
        tvendtime.setText(model.getEndtime());
        tvcurrency.setText(model.getCurrency());
        tvPrice.setText(model.getPrice());
    }
}