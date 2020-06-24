package com.codecool.scoreboard.welcome_page;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codecool.scoreboard.R;
import com.codecool.scoreboard.SlideAdapter;
import com.codecool.scoreboard.sport_events.last_events.LastEventsFragment;
import com.codecool.scoreboard.sport_events.next_events.NextEventsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {

    @BindView(R.id.main_viewpager)
    ViewPager viewPager;

    PagerAdapter pagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);

         List<Fragment> fragmentList = new ArrayList<>();
         fragmentList.add(new LastEventsFragment());
         fragmentList.add(new NextEventsFragment());

        pagerAdapter = new SlideAdapter(requireActivity().getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList);
        viewPager.setAdapter(pagerAdapter);

        return view;
    }
}