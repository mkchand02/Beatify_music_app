package com.myapp.beatify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //MainActivity which acts as a fragment holder
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }//inner if ends
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            PreferencesFragment preferencesFragment = new PreferencesFragment();
            fragmentTransaction.add(R.id.fragment_container, preferencesFragment, null);
            fragmentTransaction.commit();
        }//if ends
    }//onCreate ends
}//class ends