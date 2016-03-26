package com.sh.lynn.huang.wdaccount.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.Platform;
import com.sh.lynn.huang.wdaccount.dao.DaoSession;
import com.sh.lynn.huang.wdaccount.dao.PlatformDao;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreatPlatformActivity extends AppCompatActivity {

@Bind(R.id.et_name)
    EditText et_name;
    @Bind(R.id.et_address)
    EditText et_address;
    @Bind(R.id.et_describe)
    EditText et_describe;
    @Bind(R.id.et_loginName)
    EditText et_loginName;

    PlatformDao platformDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_platform);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        platformDao =((WDApp) getApplication()).daoSession.getPlatformDao();
    }
@OnClick(R.id.btn_next)
    public void addPlatform(View view){

    String ptName = et_name.getText().toString();
    String ptAddress = et_address.getText().toString();
    String ptLoginName = et_loginName.getText().toString();
    String ptDesc = et_describe.getText().toString();

    if(TextUtils.isEmpty(ptName)){
        et_name.setError("请输入平台名");
        return;
    }

    Platform platform = new Platform();

    platform.setAddress(ptAddress);
    platform.setName(ptName);
    platform.setDescribe(ptDesc);
    platform.setUserName(ptLoginName);

    //PlatformDao platformDao = new PlatformDao()
    long id = platformDao.insert(platform);

    Toast.makeText(this,"ID:"+id,Toast.LENGTH_LONG).show();
    }

}
