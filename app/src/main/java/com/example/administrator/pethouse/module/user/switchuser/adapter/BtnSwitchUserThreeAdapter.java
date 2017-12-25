package com.example.administrator.pethouse.module.user.switchuser.adapter;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.pethouse.R;
import com.example.administrator.pethouse.app.AppSituation;

import java.util.ArrayList;

/**
 * Created by mMaster
 * on 2017/12/19.
 * at 北京
 */

public class BtnSwitchUserThreeAdapter  extends BaseAdapter {
    private ArrayList<String> list;
    public BtnSwitchUserThreeAdapter(ArrayList<String> petnames) {
        this.list=petnames;
    }

    @Override
    public int getCount() {
        return list.size();
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
        final MyThreeHolder myHolder;
        if (convertView==null){
            myHolder= new MyThreeHolder();
            convertView = LayoutInflater.from(AppSituation.context).inflate(R.layout.btnswitchuser_list_item, null);
            myHolder.BtnListCb= convertView.findViewById(R.id.mBtnSwitchUserListItemCheckBox);
            myHolder.BtnListTv= convertView.findViewById(R.id.mBtnSwitchUserListItemmTv);
            myHolder.BtnListEt= convertView.findViewById(R.id.mBtnSwitchUserListItemmEt);


            myHolder.BtnListEt.setOnEditorActionListener(new EditText.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (!"".equals(myHolder.BtnListEt.getText().toString())&&null!=myHolder.BtnListEt){
                        myHolder.BtnListTv.setText(v.getText().toString()+"元/天");
                        myHolder.BtnListEt.setVisibility(View.INVISIBLE);
                    }

                    return false;
                }
            });






            convertView.setTag(myHolder);
        }else{
            myHolder= (MyThreeHolder) convertView.getTag();
        }
        myHolder.BtnListCb.setText(list.get(position));
        return convertView;
    }
}
class MyThreeHolder{
    public CheckBox BtnListCb;
    public TextView BtnListTv;
    public EditText BtnListEt;
}
