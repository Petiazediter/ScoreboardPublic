package com.codecool.scoreboard.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.welcome_page.screens.Page2;

public class WelcomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.welcome_page, container,false);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Write whatever to want to do after delay specified (1 sec)
                if (isFinsihed()){
                    Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_homeFragment2);
                }else {
                    Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_viewPagerFragment);
                }
            }
        }, 5000);
        return view;
    }

    private boolean isFinsihed(){
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Page2.KEY_TO_SHARED, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(Page2.KEY_TO_SHARED_BOOLEAN, false);
    }
}
