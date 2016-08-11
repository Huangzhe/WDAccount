package com.sh.lynn.huang.wdaccount.module.invest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sh.lynn.huang.wdaccount.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class InvestFragment extends Fragment {
@BindView(R.id.recyclerView_investList)
    RecyclerView recyclerView_investList;

    public InvestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_invest, container, false);

        ButterKnife.bind(this,view);

        return view;


    }

}
