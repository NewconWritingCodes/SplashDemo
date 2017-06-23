package com.example.liukang.splashdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liukang on 2017/6/23.
 */

public class MyListActivity extends AppCompatActivity{

    private ListView listView;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        listView = (ListView) findViewById(R.id.lv);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item_layout,new String[]{"img","text"},
                new int[]{R.id.item_img,R.id.item_tv});

        ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(getData(),LayoutInflater.from(MyListActivity.this));
        listView.setAdapter(viewHolderAdapter);

        listView.setSelection(13);


    }

    private List<Map<String,Object>> getData(){
        List list = new ArrayList();
        for(int i=1;i<20;i++){
            Map<String ,Object> map = new HashMap<>();
            map.put("img",R.mipmap.ic_launcher);
            map.put("text",""+i);
            list.add(map);
        }

        return list;

    }

    public class ViewHolderAdapter extends BaseAdapter{

        private List<Map<String,Object>> mData;
        private LayoutInflater mInflater;

        public ViewHolderAdapter(List<Map<String, Object>> mData, LayoutInflater mInflater) {
            this.mData = mData;
            this.mInflater = mInflater;
        }

        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView==null){
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_layout,null);
                holder.img = (ImageView) convertView.findViewById(R.id.item_img);
                holder.text = (TextView) convertView.findViewById(R.id.item_tv);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.img.setBackgroundResource((int)mData.get(position).get("img"));
            holder.text.setText((String)mData.get(position).get("text")+"after");
            return convertView;
        }

        public final class ViewHolder{
            public ImageView img;
            public TextView text;
        }
    }
}
