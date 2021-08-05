package com.example.eventsinFraments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements CommunicationListenner {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.flvcontainer);
        launchEventDetailsFragment();
    }

    private void launchEventDetailsFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment fragmentEvent = new EventDetailsFragment();
        fragmentTransaction.add(R.id.flvcontainer, fragmentEvent, "fragmentEvent").commit();

    }

    @Override
    public void launchTimeAndDateFragment(Bundle bundle) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment fragmenttimedate = new TimeAndDateFragment();
        fragmenttimedate.setArguments(bundle);
        fragmentTransaction.replace(R.id.flvcontainer, fragmenttimedate, "fragmenttimedate").addToBackStack("fragmenttimedate").commit();
    }

    @Override
    public void launchPriceDetailsFragment(Bundle bundle) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment fragmentprice = new PriceDetailsFragment();
        fragmentprice.setArguments(bundle);
        fragmentTransaction.replace(R.id.flvcontainer, fragmentprice, "fragmentprice").addToBackStack("fragmentprice").commit();
    }
}