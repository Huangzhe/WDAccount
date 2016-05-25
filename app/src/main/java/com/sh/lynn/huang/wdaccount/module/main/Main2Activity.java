package com.sh.lynn.huang.wdaccount.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jude.beam.expansion.BeamBaseActivity;
import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.module.count.FragmentCount;
import com.sh.lynn.huang.wdaccount.module.debt.DebtFragment;
import com.sh.lynn.huang.wdaccount.module.detail.DetailFragment;
import com.sh.lynn.huang.wdaccount.module.invest.InvestFragment;
import com.sh.lynn.huang.wdaccount.module.setting.SettingFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends BeamBaseActivity<MainPresenter> {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewPager)
    ViewPager viewpager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    private MainPagerAdapter mMainPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       // setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("钱管家  —  您的个人资产管家");
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tabLayout.setTabTextColors(getResources().getColor(android.R.color.darker_gray), getResources().getColor(android.R.color.white));
        viewpager.setAdapter(mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);


    }
    public class MainPagerAdapter extends FragmentStatePagerAdapter {

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentCount();
                case 1:
                    return new DetailFragment();
                case 2:
                    return new InvestFragment();
                case 3:
                    return new DebtFragment();
                default:
                    return new SettingFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "统计";
                case 1:
                    return "收支";
                case 2:
                    return "投资";
                case 3:
                    return "负债";
                default:
                    return "设置";


            }
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
          //  startActivity(new Intent(this, AboutUsActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
