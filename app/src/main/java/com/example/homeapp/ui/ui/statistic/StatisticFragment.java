package com.example.homeapp.ui.ui.statistic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.homeapp.R;
import com.example.homeapp.ui.ui.base.BaseFragment;
import com.example.homeapp.ui.ui.statistic.daily.DailyStatisticFragment;
import com.example.homeapp.ui.ui.statistic.monthly.MonthlyStatisticFragment;
import com.example.homeapp.ui.ui.statistic.weekly.WeeklyStatisticFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticFragment extends BaseFragment {

    @BindView(R.id.statistic_tabs)
    TabLayout tabLayout;

    @BindView(R.id.statistic_viewpager)
    ViewPager viewPager;


    FragmentManager fragmentManager;

    private MonthlyStatisticFragment monthlyStatisticFragment;
    private WeeklyStatisticFragment weeklyStatisticFragment;
    private DailyStatisticFragment dailyStatisticFragment;

    private int viewPagerPosition;
    
    public StatisticFragment(){
        // to construct
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);

        ButterKnife.bind(this, view);

        monthlyStatisticFragment = new MonthlyStatisticFragment();
        weeklyStatisticFragment = new WeeklyStatisticFragment();
        dailyStatisticFragment = new DailyStatisticFragment();


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager,true);


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(dailyStatisticFragment,"Daily");
        adapter.addFragment(weeklyStatisticFragment,"Weekly");
        adapter.addFragment(monthlyStatisticFragment,"Monthly");

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }



    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}