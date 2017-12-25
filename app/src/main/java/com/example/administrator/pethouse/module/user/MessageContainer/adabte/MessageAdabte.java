package com.example.administrator.pethouse.module.user.MessageContainer.adabte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.module.user.MessageContainer.bean.MessageBean;
import java.util.List;

/**
 * It.Boss 红叶-QiYe
 */

public class MessageAdabte extends BaseAdapter {
    private List<MessageBean> list;

    public MessageAdabte(List<MessageBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
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
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_messageadabte,null);
            myViewHolder.mMeesageImage=convertView.findViewById(R.id.mMeesageImage);
            myViewHolder.mMeesageTexts=convertView.findViewById(R.id.mMeesageTexts);
            myViewHolder.mMeesageTextss=convertView.findViewById(R.id.mMeesageTextss);
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder= (MyViewHolder) convertView.getTag();
        }
        Glide.with(parent.getContext()).load(list.get(position).getTitle()).into(myViewHolder.mMeesageImage);

        myViewHolder.mMeesageTexts.setText(list.get(position).getName());
        myViewHolder.mMeesageTextss.setText(list.get(position).getDetails());

        return convertView;
    }
    class  MyViewHolder{
        private ImageView mMeesageImage;
        private TextView mMeesageTexts,mMeesageTextss;
    }
}
