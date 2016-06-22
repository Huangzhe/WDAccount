package com.sh.lynn.huang.wdaccount.module.main;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.jude.beam.expansion.BeamBaseActivity;
import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.ui.PlatformFragment;
import com.sh.lynn.huang.wdaccount.ui.TenderFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.tab_menu)
    RadioGroup tab_menu;
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        //setSupportActionBar(toolbar);

        tab_menu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_total:
                        break;
                    case R.id.rb_platfrom:
                      //  getFragmentManager().beginTransaction().add(R.id.main_content_fg,new PlatformFragment()).commit();

                    break;
                    case R.id.rb_tender:
                       // getFragmentManager().beginTransaction().replace(R.id.main_content_fg, TenderFragment.newInstance()).commit();
                        break;
                    case R.id.rb_money:
                        break;
                    case R.id.rb_Me:
                        break;

                }
            }
        });
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
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }


}
