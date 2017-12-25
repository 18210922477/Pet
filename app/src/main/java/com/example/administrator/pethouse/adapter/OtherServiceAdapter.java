package com.example.administrator.pethouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.entity.HomeFamilyItemBean;
import com.example.administrator.pethouse.module.home.HomeFamilyDetails;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/21
 */

public class OtherServiceAdapter extends BaseAdapter {
    private List<HomeFamilyItemBean.DescBean.FosterOtherServicesBean> otherList;
    private Context context;
    private ViewHolder holder;

    public OtherServiceAdapter(List<HomeFamilyItemBean.DescBean.FosterOtherServicesBean> otherList, HomeFamilyDetails homeFamilyDetailsClass) {
          this.otherList=otherList;
          this.context=homeFamilyDetailsClass;
    }

    @Override
    public int getCount() {
        return otherList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        holder = new ViewHolder();
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.other_item, null);
           holder.name = view.findViewById(R.id.tv_name);
            holder.price = view.findViewById(R.id.tv_price);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
            holder.name.setText(otherList.get(i).getPetTypeName());
        holder.price.setText(otherList.get(i).getServicePrice());
        return view;
    }

    class ViewHolder{
        TextView name;
        TextView price;

    }
}
