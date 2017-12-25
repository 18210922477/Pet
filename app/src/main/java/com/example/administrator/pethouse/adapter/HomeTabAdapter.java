package com.example.administrator.pethouse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.entity.NearbyBean;
import com.example.administrator.pethouse.module.home.begin.HomeScreenActivity;

import java.util.List;

/**
 * Tap into soulful code @_阿钟 2017/12/18
 */

public class HomeTabAdapter  extends BaseAdapter{
    private List<NearbyBean.DescBean> dataList;
    private Context context;
    private ViewHolder holder;
    private TextView list_price;

    public HomeTabAdapter(List<NearbyBean.DescBean> dataList, HomeScreenActivity homeScreenActivity) {
         this.dataList=dataList;
         this.context=homeScreenActivity;
    }


    @Override
    public int getCount() {
        return dataList.size();
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
           holder.List_of_heades= view.findViewById(R.id.List_of_heades);
            holder.list_shop = view.findViewById(R.id.list_shop);
            holder.list_particulars = view.findViewById(R.id.list_particulars);
           holder.list_distance = view.findViewById(R.id.list_distance);
           holder.mRatingBar = view.findViewById(R.id.mRating);
            holder.list_price = view.findViewById(R.id.list_price);
            view.setTag(holder);
        }else{
          holder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(dataList.get(i).getUserImage()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.List_of_heades);
        holder.list_shop.setText(dataList.get(i).getFamily());
        holder.list_particulars.setText(dataList.get(i).getAddress());

        holder.list_distance.setText(dataList.get(i).getDistance()+"");
        holder.mRatingBar.setRating((float) dataList.get(i).getScore());
        holder.list_distance.setText(dataList.get(i).getDistance()+"");
        holder.list_price.setText( dataList.get(i).getPrice()+"");
        return view;
    }

    class ViewHolder{
        ImageView List_of_heades;
        TextView list_shop;
        TextView list_particulars;
        TextView list_distance;
        RatingBar mRatingBar;
        TextView  list_price;
    }
}
