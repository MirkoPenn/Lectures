package com.pennone.lectures;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        navigateLectures();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_lectures:

                    navigateLectures();

                    return true;

                case R.id.navigation_recordings:

                   navigateRecordings();

                    return true;

                case R.id.navigation_subjects:

                    navigateSubjects();

                    return true;
            }
            return false;
        }
    };

    private void navigateLectures() {

        mTextMessage.setText(R.string.title_lectures);
        setTitle(R.string.title_lectures);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewLectureActivity.class);
                startActivity(intent);
            }
        });

        fab.setImageResource(R.drawable.ic_home_black_24dp);
        fab.setVisibility(View.VISIBLE);

    }


    private void navigateRecordings() {
        mTextMessage.setText(R.string.title_recordings);
        setTitle(R.string.title_recordings);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NewLectureActivity.class);
                startActivity(intent);
            }
        });

        fab.setImageResource(R.drawable.ic_notifications_black_24dp);
        fab.setVisibility(View.VISIBLE);

    }

    private void navigateSubjects() {

        mTextMessage.setText(R.string.title_subjects);
        setTitle(R.string.title_subjects);
        fab.setVisibility(View.INVISIBLE);

    }

}
