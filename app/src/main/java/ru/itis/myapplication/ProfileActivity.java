package ru.itis.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private ImageView userPhoto;
    private TextView tvFullName;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userPhoto = findViewById(R.id.user_photo);
        tvFullName = findViewById(R.id.user_full_name);
        tvEmail = findViewById(R.id.tv_email);

        String fullName = getIntent().getStringExtra("fullName");
        String email = getIntent().getStringExtra("email");
        Integer photo = getIntent().getIntExtra("photo", 0);

        userPhoto.setImageResource(photo);
        tvFullName.setText(fullName);
        tvEmail.setText(email);

    }
}