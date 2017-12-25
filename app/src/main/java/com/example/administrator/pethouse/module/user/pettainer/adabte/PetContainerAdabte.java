package com.example.administrator.pethouse.module.user.pettainer.adabte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pethouse.R;

/**
 * It.Boss 红叶-QiYe
 */

public class PetContainerAdabte extends BaseAdapter {

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
            convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_petcontainers,null);
            myViewHolder.mPetcontainersstitle=convertView.findViewById(R.id.mPetcontainersstitle);
            myViewHolder.mPetcontainerssname=convertView.findViewById(R.id.mPetcontainerssname);
            myViewHolder.mPetcontainersssynopsis=convertView.findViewById(R.id.mPetcontainersssynopsis);
              convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load("").into(myViewHolder.mPetcontainersstitle);
        myViewHolder.mPetcontainerssname.setText("");
        myViewHolder.mPetcontainersssynopsis.setText("");
        return convertView;
    }
    class  MyViewHolder{
     private ImageView mPetcontainersstitle;
     private TextView mPetcontainerssname,mPetcontainersssynopsis;
    }
}
