package com.codecool.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*@BindView(R.id.main_view_pager)
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  ButterKnife.bind(this);

       // List<Fragment> fragmentList = new ArrayList<>();
      //  fragmentList.add(new Fragment1());
     //   fragmentList.add(new Fragment2());

        //pagerAdapter = new SlideAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList);
      //  viewPager.setAdapter(pagerAdapter);

        getSupportActionBar().hide();
    }


}