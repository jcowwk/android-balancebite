package org.techtown.balancebite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager2 pager;
    public static Context contextMain;

    String selectedItemTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextMain = this;

        PagerAdapter adapter = new PagerAdapter(this);
        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        pager.setCurrentItem(0);

        adapter.addItem(new MainFragment());
        adapter.addItem(new SearchFragment());
        adapter.addItem(new SettingFragment());

        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home_btn:
                        pager.setCurrentItem(0);
                        return true;
                    case R.id.search_btn:
                        pager.setCurrentItem(1);
                        return true;
                    case R.id.setting_btn:
                        pager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
    }
    public void goItemPage(){
        Intent intent = new Intent(getApplicationContext(), DetailItemPage.class);
        startActivity(intent);
    }
    public void setItemTitle(String title){
        selectedItemTitle = title;
    }
    public String getItemTitle(){
        return selectedItemTitle;
    }
}