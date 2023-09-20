package com.dogukandemirel.workshopapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    private static final String PREFS_NAME = "UserProfilePrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final int REQUEST_IMAGE_PICK = 1;
    private static final int STORAGE_PERMISSION_CODE = 2;

    private EditText etUsername;
    private EditText etEmail;
    private ImageView ivProfilePhoto;
    private Button btnSaveProfile;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        sharedPreferences = getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        ivProfilePhoto = view.findViewById(R.id.ivProfilePhoto);
        btnSaveProfile = view.findViewById(R.id.btnSaveProfile);


        String savedUsername = sharedPreferences.getString(KEY_USERNAME, "");
        String savedEmail = sharedPreferences.getString(KEY_EMAIL, "");


        etUsername.setText(savedUsername);
        etEmail.setText(savedEmail);


        ivProfilePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                            STORAGE_PERMISSION_CODE);
                } else {

                    openGallery();
                }
            }
        });

        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kullanıcıdan alınan bilgileri kaydet
                String username = etUsername.getText().toString();
                String email = etEmail.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_USERNAME, username);
                editor.putString(KEY_EMAIL, email);
                editor.apply();


                TextView tvSavedUsername = view.findViewById(R.id.tvSavedUsername);
                TextView tvSavedEmail = view.findViewById(R.id.tvSavedEmail);


                String savedUsername = sharedPreferences.getString(KEY_USERNAME, "");
                String savedEmail = sharedPreferences.getString(KEY_EMAIL, "");


                tvSavedUsername.setText("Kullanıcı Adı: " + savedUsername);
                tvSavedEmail.setText("E-posta: " + savedEmail);
            }
        });

        return view;
    }


    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_PICK);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                openGallery();
            } else {

            }
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                Uri selectedImageUri = data.getData();

                ivProfilePhoto.setImageURI(selectedImageUri);
            }
        }
    }
}