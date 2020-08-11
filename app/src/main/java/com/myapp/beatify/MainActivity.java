package com.myapp.beatify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //MainActivity which acts as a fragment holder
    public static FragmentManager fragmentManager;
    private static final String COLLECTION_TITLE = "Music";
    public static AppCompatActivity activity = null;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Map<String, Object> note = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }//inner if ends

//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //PreferencesFragment preferencesFragment = new PreferencesFragment();
            fragmentManager.beginTransaction().add(R.id.fragment_container, new PreferencesFragment(), null).commit();
//            fragmentTransaction.commit();
            createMusicCollection();
        }//if ends
    }//onCreate ends

    public static void onGenreClicked() {
        fragmentManager.beginTransaction().replace(R.id.fragment_container, new HostFragment(), null).commit();
    }

    private void createMusicCollection() {
        note.put("Title1", "");

    }

    public static void logOut() {
        FirebaseAuth.getInstance().signOut();
        activity.finish();
        activity.startActivity(new Intent(activity, LoginActivity.class));
    }

}//class ends