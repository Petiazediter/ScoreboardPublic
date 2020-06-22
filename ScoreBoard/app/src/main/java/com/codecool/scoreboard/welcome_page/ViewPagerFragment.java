package com.codecool.scoreboard.welcome_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.fragments.WelcomeFragment;
import com.codecool.scoreboard.welcome_page.screens.Page1;
import com.codecool.scoreboard.welcome_page.screens.Page2;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_view_pager, container, false);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Page1());
        fragmentList.add(new Page2());

        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getFragmentManager(), getLifecycle(),fragmentList);
        ViewPager2 viewPager2 = view.findViewById(R.id.view_pager_welcpage);
        viewPager2.setAdapter(viewPagerFragmentAdapter);
        return view;
    }
}