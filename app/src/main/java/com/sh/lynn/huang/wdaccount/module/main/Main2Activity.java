package com.sh.lynn.huang.wdaccount.module.main;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.module.count.FragmentCount;
import com.sh.lynn.huang.wdaccount.module.debt.DebtFragment;
import com.sh.lynn.huang.wdaccount.module.detail.AddBankCardDetailActivity;
import com.sh.lynn.huang.wdaccount.module.detail.DetailFragment;
import com.sh.lynn.huang.wdaccount.module.invest.AddInvestActivity;
import com.sh.lynn.huang.wdaccount.module.invest.InvestFragment;
import com.sh.lynn.huang.wdaccount.utils.PopupHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements MainContract.View , NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.viewPager)
    ViewPager viewpager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

  //  @Bind(R.id.tv_add_cash)
    TextView tv_add_cash;

  //  @Bind(R.id.tv_add_invest)
    TextView tv_add_invest;

  //  @Bind(R.id.tv_add_back)
    TextView tv_add_back;

    private MainPagerAdapter mMainPagerAdapter;
    private  MainContract.Presenter mainPresenter;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // setSupportActionBar(toolbar);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // toolbar.setTitle("钱掌柜  —  您的个人资产管家");
       // getSupportActionBar().setTitle("钱掌柜  —  您的个人资产管家");
        ButterKnife.bind(this);
       setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tabLayout.setTabTextColors(getResources().getColor(android.R.color.darker_gray), getResources().getColor(android.R.color.white));

        viewpager.setAdapter(mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);
        mainPresenter = new MainPresenter(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }



    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter =presenter;
    }

    @Override
    public void gotoAddBankRecord() {

        Intent intent = new Intent(this, AddBankCardDetailActivity.class);
        startActivity(intent);

    }

    @Override
    public void gotoAddInvestRecord() {
        Intent intent = new Intent(this, AddInvestActivity.class);
        startActivity(intent);

    }

    @Override
    public void gotoAddReturnRecord() {

    }

    @Override
    public void gotoBankCardList() {

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_bankcard:

                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                default:
                    return new DebtFragment();

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
                default:
                    return "负债";


            }
        }

        @Override
        public int getCount() {
            return 4;
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
          //  startActivity(new Intent(this, AboutUsActivity.class));
            popupWindow =  PopupHelper.newBasicPopupWindow(this);
            View view = View.inflate(this,R.layout.item_title_pop,null);
            DisplayMetrics outMetrics = new DisplayMetrics();
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
            popupWindow.setContentView(view);
            popupWindow.setAnimationStyle(R.style.Animations_PopDownMenuRight);
            //   popupWindow.showAtLocation(tabLayout, Gravity.RIGHT,0,);
            popupWindow.showAsDropDown(findViewById(R.id.action_add),outMetrics.widthPixels,-10);

            tv_add_cash = (TextView) view.findViewById(R.id.tv_add_cash);
            tv_add_invest = (TextView) view.findViewById(R.id.tv_add_invest);
            tv_add_back = (TextView) view.findViewById(R.id.tv_add_back);

            tv_add_cash.setOnClickListener(new MyPopItemClickListenre());
            tv_add_invest.setOnClickListener(new MyPopItemClickListenre());

            tv_add_back.setOnClickListener(new MyPopItemClickListenre());


            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyPopItemClickListenre implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            popupWindow.dismiss();
            switch(v.getId()){
                case R.id.tv_add_cash:
                    mainPresenter.goToAddPage(RecordType.BankRecord);
                    break;
                case R.id.tv_add_invest:
                    mainPresenter.goToAddPage(RecordType.InvestRecord);
                    break;
                case R.id.tv_add_back:
                    mainPresenter.goToAddPage(RecordType.ReturnRecord);
                    break;
            }

        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
