package com.codecool.scoreboard.welcome_page.screens;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.codecool.scoreboard.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Page2 extends Fragment {

    public static final String KEY_TO_SHARED ="key";
    public static final String KEY_TO_SHARED_BOOLEAN ="key_bl";

    @BindView(R.id.next_button_2)
    Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_page2, container, false);
        ButterKnife.bind(this,v);

        nextButton.setOnClickListener(v1 -> {
            finishTest();
            Navigation.findNavController(v).navigate(R.id.action_viewPagerFragment_to_homeFragment);
        });

        return v;
    }

    void finishTest(){
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(KEY_TO_SHARED, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_TO_SHARED_BOOLEAN, true);
        editor.apply();
    }
}