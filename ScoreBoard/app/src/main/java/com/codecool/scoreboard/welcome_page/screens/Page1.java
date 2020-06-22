package com.codecool.scoreboard.welcome_page.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codecool.scoreboard.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Page1 extends Fragment {

    @BindView(R.id.next_button_1)
    Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page1, container, false);
        ButterKnife.bind(this,view);

        ViewPager2 viewPager2 = getActivity().findViewById(R.id.view_pager_welcpage);

        nextButton.setOnClickListener(v -> {
            viewPager2.setCurrentItem(1);
        });

        return view;
    }
}