package com.dogukandemirel.workshopapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfilePrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String email = sharedPreferences.getString("email", "");
        String age = sharedPreferences.getString("age", "");
        String occupation = sharedPreferences.getString("occupation", "");
        String education = sharedPreferences.getString("education", "");
        String gender = sharedPreferences.getString("gender", "");
        String hobbies = sharedPreferences.getString("hobbies", "");
        String address = sharedPreferences.getString("address", "");

        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvAge = findViewById(R.id.tvAge);
        TextView tvOccupation = findViewById(R.id.tvOccupation);
        TextView tvEducation = findViewById(R.id.tvEducation);
        TextView tvGender = findViewById(R.id.tvGender);
        TextView tvHobbies = findViewById(R.id.tvHobbies);
        TextView tvAddress = findViewById(R.id.tvAddress);

        tvUsername.setText("Kullanıcı Adı: " + username);
        tvEmail.setText("E-posta: " + email);
        tvAge.setText("Yaş: " + age);
        tvOccupation.setText("Meslek: " + occupation);
        tvEducation.setText("Eğitim Durumu: " + education);
        tvGender.setText("Cinsiyet: " + gender);
        tvHobbies.setText("Hobiler: " + hobbies);
        tvAddress.setText("Adres: " + address);



        String profilePhotoUri = sharedPreferences.getString("profilePhotoUri", "");


        ImageView ivProfilePhoto = findViewById(R.id.ivProfilePhoto);


        if (!TextUtils.isEmpty(profilePhotoUri)) {
            Uri photoUri = Uri.parse(profilePhotoUri);
            ivProfilePhoto.setImageURI(photoUri);
        } else {

            ivProfilePhoto.setImageResource(R.drawable.selectimage);
        }
    }
}