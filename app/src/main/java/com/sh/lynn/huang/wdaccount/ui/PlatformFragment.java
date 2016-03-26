package com.sh.lynn.huang.wdaccount.ui;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.adapter.PlatformAdapter;
import com.sh.lynn.huang.wdaccount.been.Platform;
import com.sh.lynn.huang.wdaccount.dao.PlatformDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PlatformFragment extends Fragment {

    PlatformDao platformDao;
    @Bind(R.id.rl_platform)
    RecyclerView rl_platform;

    PlatformAdapter platformAdapter;

    List<Platform> platforms = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_platform,null);

        ButterKnife.bind(this,view);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CreatPlatformActivity.class);
                startActivity(intent);
            }
        });

        initData();

//设置布局管理器
        rl_platform.setLayoutManager(new LinearLayoutManager(getActivity()));
        rl_platform.setHasFixedSize(true);

//设置Item增加、移除动画
        rl_platform.setItemAnimator(new DefaultItemAnimator());
//添加分割线
//        rl_platform.addItemDecoration(new DividerItemDecoration(
//                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

        platformAdapter = new PlatformAdapter(platforms);
        rl_platform.setAdapter(platformAdapter);
        return view;
    }

    private void initData(){
        platformDao =((WDApp)getActivity(). getApplication()).daoSession.getPlatformDao();
        platforms =  platformDao.loadAll();
    }
}
