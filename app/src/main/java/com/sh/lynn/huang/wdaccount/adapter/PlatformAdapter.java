package com.sh.lynn.huang.wdaccount.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sh.lynn.huang.wdaccount.R;
import com.sh.lynn.huang.wdaccount.been.Platform;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Huangz on 16/3/21.
 */
public class PlatformAdapter extends RecyclerView.Adapter<PlatformAdapter.ViewHolder> {

    List<Platform> platforms;
    public PlatformAdapter(List<Platform> data){
        platforms =data;
    }

    @Override
    public PlatformAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_platform,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlatformAdapter.ViewHolder holder, int position) {

        Platform platform = platforms.get(position);

        holder.tv_platformName.setText(platform.getName());
        holder.tv_platormAdrs.setText(platform.getAddress());
    }

    @Override
    public int getItemCount() {
        return platforms.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_platformName)
        TextView tv_platformName;
        @BindView(R.id.tv_platormAdrs)
        TextView tv_platormAdrs;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
