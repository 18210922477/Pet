package com.example.administrator.pethouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.entity.PetTabBean;
import com.example.administrator.pethouse.module.home.begin.HomeScreenActivity;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/20
 */

public class PetTabListAdapter extends BaseAdapter {
    private List<PetTabBean.DescBean> petList;
    private Context context;
    private ViewHolder holder;

    public PetTabListAdapter(List<PetTabBean.DescBean> petList, HomeScreenActivity homeScreenActivity) {
   this.petList=petList;
   this.context=homeScreenActivity;
    }

    @Override
    public int getCount() {
        return petList.size();
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
            view = LayoutInflater.from(context).inflate(R.layout.home_item_address, null);
            holder.imageView= view.findViewById(R.id.List_of_heades);
           holder.textView= view.findViewById(R.id.list_price);
           holder.name= view.findViewById(R.id.list_shop);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(petList.get(i).getPetTypeImage()).into(holder.imageView);
        holder.textView.setText(petList.get(i).getPetPrice()+"");
        holder.name.setText(petList.get(i).getTypeName());
        
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
        TextView name;
        
    }
}
