package com.example.administrator.pethouse.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.module.home.begin.HomeScreenActivity;

import java.util.ArrayList;

/**
 * Tap into soulful code @_阿钟 2017/12/15
 */

public class MyHomeListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> stringList;
    private ViewHolder holder;

    public MyHomeListAdapter(HomeScreenActivity homeScreenActivity, ArrayList<String> stringList) {
        this.context=homeScreenActivity;
        this.stringList=stringList;

    }

    @Override
    public int getCount() {
        return stringList.size();
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
            view = LayoutInflater.from(context).inflate(R.layout.pop_pet_item, null);
           holder.name = view.findViewById(R.id.mPopItem_name);
          holder.imageView = view.findViewById(R.id.mPopItem_image);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
          holder.name.setText(stringList.get(i));


        return view;
    }
    class ViewHolder{
        TextView name;
        ImageView imageView;
    }
}
