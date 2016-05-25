package com.sh.lynn.huang.wdaccount.module.detail;


import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.sh.lynn.huang.wdaccount.model.been.DetailPageBean;

/**
 * A simple {@link Fragment} subclass.
 */
@RequiresPresenter(DetailPresenter.class)
public class DetailFragment extends BeamListFragment<DetailPresenter,DetailPageBean> {


    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return null;
    }
}
