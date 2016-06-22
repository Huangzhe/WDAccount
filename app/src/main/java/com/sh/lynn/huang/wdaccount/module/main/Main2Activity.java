package com.sh.lynn.huang.wdaccount.module.main;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

import com.jude.beam.expansion.BeamBaseActivity;
import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.module.count.FragmentCount;
import com.sh.lynn.huang.wdaccount.module.debt.DebtFragment;
import com.sh.lynn.huang.wdaccount.module.detail.DetailFragment;
import com.sh.lynn.huang.wdaccount.module.invest.InvestFragment;
import com.sh.lynn.huang.wdaccount.module.setting.SettingFragment;
import com.sh.lynn.huang.wdaccount.utils.PopupHelper;

import java.lang.reflect.Field;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("钱掌柜  —  您的个人资产管家");
       // getSupportActionBar().setTitle("钱掌柜  —  您的个人资产管家");
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_add) {

            PopupMenu popupMenu =new PopupMenu(this, findViewById(R.id.action_add));
            popupMenu.getMenuInflater().inflate(R.menu.menu_main2,popupMenu.getMenu());
            try {
                Field field = popupMenu.getClass().getDeclaredField("mPopup");
                field.setAccessible(true);
                MenuPopupHelper mHelper = (MenuPopupHelper) field.get(popupMenu);
                mHelper.setForceShowIcon(true);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
            popupMenu.show();
        }
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_add) {
//          //  startActivity(new Intent(this, AboutUsActivity.class));
//            PopupWindow popupWindow =  PopupHelper.newBasicPopupWindow(this);
//            View view = View.inflate(this,R.layout.item_title_pop,null);
//            DisplayMetrics outMetrics = new DisplayMetrics();
//             getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
//            popupWindow.setContentView(view);
//            popupWindow.setAnimationStyle(R.style.Animations_PopDownMenuRight);
//         //   popupWindow.showAtLocation(tabLayout, Gravity.RIGHT,0,);
//            popupWindow.showAsDropDown(tabLayout,outMetrics.widthPixels,-tabLayout.getHeight()-10);
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

}
