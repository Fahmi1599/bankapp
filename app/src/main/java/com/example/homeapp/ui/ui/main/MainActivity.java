package com.example.homeapp.ui.ui.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.homeapp.R;
import com.example.homeapp.ui.ui.base.BaseActivity;
import com.example.homeapp.ui.ui.card.CardFragment;
import com.example.homeapp.ui.ui.helper.BottomNavigationHelper;
import com.example.homeapp.ui.ui.home.HomeFragment;
import com.example.homeapp.ui.ui.profile.ProfileFragment;
import com.example.homeapp.ui.ui.statistic.StatisticFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener, PopupMenu.OnMenuItemClickListener {


    @BindView(R.id.main_bottom_navigation)
    BottomNavigationView bottomNavigationView;

    CardFragment cardFragment;
    HomeFragment homeFragment;
    StatisticFragment statisticFragment;
    ProfileFragment profileFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        homeFragment = new HomeFragment();
        cardFragment = new CardFragment();
        statisticFragment = new StatisticFragment();
        profileFragment = new ProfileFragment();

        BottomNavigationHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        replaceFragment(homeFragment);


    }

    private void replaceFragment(Fragment fragment) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(R.id.frame_layout, fragment);
            fragmentTransaction.commit();
    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                replaceFragment(homeFragment);
                break;
            case R.id.navigation_statistic:
                replaceFragment(statisticFragment);
                break;
            case R.id.navigation_card:
                replaceFragment(cardFragment);
                break;
            case R.id.navigation_profile:
                replaceFragment(profileFragment);
                break;

            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_home:
                replaceFragment(homeFragment);
                break;
            case R.id.navigation_statistic:
                replaceFragment(statisticFragment);
                break;
            case R.id.navigation_card:
                replaceFragment(cardFragment);
                break;
            case R.id.navigation_profile:
                replaceFragment(profileFragment);
                break;

            default:
                break;
        }
        return true;
    }
}