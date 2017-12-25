package com.example.administrator.pethouse.module.user.ordercontainer.adabte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pethouse.R;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * It.Boss 红叶-QiYe
 */

public class OrderListviewAdabte extends BaseAdapter {

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder=null;
        if (convertView==null){
            myViewHolder=new MyViewHolder();
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_orderlistviewss,null);
            myViewHolder.mOrderCirleImguserss=convertView.findViewById(R.id.mOrderCirleImguserss);
            myViewHolder.mOrderCirleImgclientss=convertView.findViewById(R.id.mOrderCirleImgclientss);
            myViewHolder.mOrderstatess=convertView.findViewById(R.id.mOrderstatess);
              convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load("").into(myViewHolder.mOrderCirleImguserss);
        Glide.with(parent.getContext()).load("").into(myViewHolder.mOrderCirleImgclientss);
        myViewHolder.mOrderstatess.setText("");

        return convertView;
    }
    class  MyViewHolder{
     private CircleImageView mOrderCirleImguserss,mOrderCirleImgclientss;
     private TextView mOrderstatess;
    }
}
