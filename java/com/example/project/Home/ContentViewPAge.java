package com.example.project.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.project.R;

public class ContentViewPAge extends AppCompatActivity {

    TextView name,track,mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_view_page);

        name = findViewById(R.id.txt_c_name);
        track = findViewById(R.id.txt_track);
        mode = findViewById(R.id.txt_mode);

        String names= getIntent().getStringExtra("course_name");
        String tracks= getIntent().getStringExtra("course_mode");
        String modes= getIntent().getStringExtra("course_track");

        name.setText(names);
        track.setText(tracks);
        mode.setText(modes);
    }
}