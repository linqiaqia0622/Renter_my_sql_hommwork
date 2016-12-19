package com.qiaqia.renter.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiaqia.renter.R;
import com.qiaqia.renter.mvp.model.FilterEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 洽洽 on 2016/12/18.
 */

public class FilterAdapter extends BaseAdapter {
    private List<com.qiaqia.renter.mvp.model.FilterEntity> mList = new ArrayList<com.qiaqia.renter.mvp.model.FilterEntity>();
    protected Context mContext;
    private FilterEntity selectedEntity;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public FilterEntity getItem(int position) {
        return     mList.get(position);
       
    }

    

    public List<FilterEntity> getData(){
        return mList;
    }

    public void setSelectedEntity(FilterEntity filterEntity) {
        this.selectedEntity = filterEntity;
        for (FilterEntity entity : getData()) {
            entity.setSelected(entity.getKey().equals(selectedEntity.getKey()));
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_filter_one, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        FilterEntity entity = getItem(position);

        holder.tvTitle.setText(entity.getKey());
        if (entity.isSelected()) {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.orange));
        } else {
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.font_black_3));
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.tv_title)
        TextView tvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
