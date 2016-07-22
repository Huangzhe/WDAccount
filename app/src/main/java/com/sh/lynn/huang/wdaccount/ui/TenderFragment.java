package com.sh.lynn.huang.wdaccount.ui;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.adapter.TenderRecordAdapter;
import com.sh.lynn.huang.wdaccount.dao.TenderRecordDao;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A fragment representing a list of Items.
 * <p>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TenderFragment extends Fragment {

    TenderRecordDao tenderRecordDao;
    @Bind(R.id.rl_platform)
    RecyclerView mRecyleview;
    private  List<TenderRecord> tenderRecords = new ArrayList<>();
private TenderRecordAdapter tenderRecordAdapter;
    private OnListFragmentInteractionListener mListener;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TenderFragment() {
    }

    @SuppressWarnings("unused")
    public static TenderFragment newInstance() {
        TenderFragment fragment = new TenderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_platform,null);

        ButterKnife.bind(this,view);

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CreatTenderRecordActivity.class);
                startActivity(intent);
            }
        });

        initData();

        //设置布局管理器
        mRecyleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyleview.setHasFixedSize(true);

//设置Item增加、移除动画
        mRecyleview.setItemAnimator(new DefaultItemAnimator());
//添加分割线
//        rl_platform.addItemDecoration(new DividerItemDecoration(
//                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

        tenderRecordAdapter = new TenderRecordAdapter(tenderRecords,mListener);
        mRecyleview.setAdapter(tenderRecordAdapter);
        return view;
    }
    private void initData(){
        tenderRecordDao =((WDApp)getActivity(). getApplication()).daoSession.getTenderRecordDao();
        tenderRecords =  tenderRecordDao.loadAll();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(TenderRecord item);
    }

}
