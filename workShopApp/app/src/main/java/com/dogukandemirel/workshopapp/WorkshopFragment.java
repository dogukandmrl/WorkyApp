package com.dogukandemirel.workshopapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class WorkshopFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private ArrayList<Workshops> workshopsArrayList;
    private String[] workshopsHeading;
    private int[] imageResourceId;
    private RecyclerView recyclerView;

    public WorkshopFragment() {

    }


    public static WorkshopFragment newInstance(String param1, String param2) {
        WorkshopFragment fragment = new WorkshopFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_workshop, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataInitialize();
        recyclerView = view.findViewById(R.id.rvWorkshop);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        WorkShopAdapter workShopAdapter = new WorkShopAdapter(getContext(),workshopsArrayList);
        recyclerView.setAdapter(workShopAdapter);
        workShopAdapter.notifyDataSetChanged();


        workShopAdapter.setOnItemClickListener(new WorkShopAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Workshops clickedWorkshop = workshopsArrayList.get(position);
                String emailAddress = clickedWorkshop.getEmailAddress();
                String emailSubject = clickedWorkshop.getEmailSubject();
                String emailContent = clickedWorkshop.getEmailContent();


                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + emailAddress));
                intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
                intent.putExtra(Intent.EXTRA_TEXT, emailContent);

                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {

                    Toast.makeText(getContext(), "E-posta gönderme uygulaması bulunamadı.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void dataInitialize() {
        workshopsArrayList = new ArrayList<>();

        Workshops workshop1 = new Workshops(getString(R.string.head_1), R.drawable.a, "alici1@ornek.com", "Konu 1", "İçerik 1");
        Workshops workshop2 = new Workshops(getString(R.string.head_2), R.drawable.b, "alici2@ornek.com", "Konu 2", "İçerik 2");
        Workshops workshop3 = new Workshops(getString(R.string.head_3), R.drawable.c, "alici3@ornek.com", "Konu 3", "İçerik 3");
        Workshops workshop4 = new Workshops(getString(R.string.head_4), R.drawable.d, "alici4@ornek.com", "Konu 4", "İçerik 4");
        Workshops workshop5 = new Workshops(getString(R.string.head_5), R.drawable.e, "alici5@ornek.com", "Konu 5", "İçerik 5");
        Workshops workshop6 = new Workshops(getString(R.string.head_6), R.drawable.f, "alici6@ornek.com", "Konu 6", "İçerik 6");
        Workshops workshop7 = new Workshops(getString(R.string.head_7), R.drawable.g, "alici7@ornek.com", "Konu 7", "İçerik 7");
        Workshops workshop8 = new Workshops(getString(R.string.head_8), R.drawable.h, "alici8@ornek.com", "Konu 8", "İçerik 8");
        Workshops workshop9 = new Workshops(getString(R.string.head_9), R.drawable.j, "alici9@ornek.com", "Konu 9", "İçerik 9");
        Workshops workshop10 = new Workshops(getString(R.string.head_10), R.drawable.k, "alici10@ornek.com", "Konu 10", "İçerik 10");

        workshopsArrayList.add(workshop1);
        workshopsArrayList.add(workshop2);
        workshopsArrayList.add(workshop3);
        workshopsArrayList.add(workshop4);
        workshopsArrayList.add(workshop5);
        workshopsArrayList.add(workshop6);
        workshopsArrayList.add(workshop7);
        workshopsArrayList.add(workshop8);
        workshopsArrayList.add(workshop9);
        workshopsArrayList.add(workshop10);
    }


}